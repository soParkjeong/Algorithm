/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private static class Pair{
        int depth;
        TreeNode node;

        Pair(int depth,TreeNode node){
            this.depth=depth;
            this.node=node;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Pair dfs(TreeNode cur){
        if(cur==null){
            return new Pair(0,null);
        }

        Pair L=dfs(cur.left);
        Pair R=dfs(cur.right);

        if(L.depth==R.depth){
            return new Pair(L.depth+1,cur);
        }

        if(L.depth>R.depth){
            return new Pair(L.depth+1,L.node);
        }else{
            return new Pair(R.depth+1,R.node);
        }
    }
}