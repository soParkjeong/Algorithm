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
    private static final long MOD = 1_000_000_007L;

    private long totalSum = 0;
    private long max = 0;

    public int maxProduct(TreeNode root) {
        totalSum = sum(root);    
        dfs(root);                    
        return (int) (max % MOD);    
    }

    // 트리 전체 합 구하기
    private long sum(TreeNode node) {
        if (node == null) return 0L;
        return node.val + sum(node.left) + sum(node.right);
    }

    // 서브트리끼리의 합->최대 곱(서브트리*(전체-서브트리)) 갱신
    private long dfs(TreeNode node) {
        if (node == null) return 0L;

        long left = dfs(node.left);
        long right = dfs(node.right);

        long subSum = left + right + node.val;

        long product = subSum * (totalSum - subSum);
        if (product > max) max = product;

        return subSum;
    }
}
