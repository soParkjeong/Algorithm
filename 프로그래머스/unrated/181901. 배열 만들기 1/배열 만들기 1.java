class Solution {
    public int[] solution(int n, int k){
        int length=n/k;
        int[]result=new int[length];
        int a=0;
        
        for(int i=1;i<=length;i++){
            result[a]=k*i;
            a++;
        }
        return result;
    }
}