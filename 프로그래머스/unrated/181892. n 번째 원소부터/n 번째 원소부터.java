class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] result=new int[num_list.length-n+1];
        int k=num_list.length;
        int m=0;
        
        for(int i=n-1;i<k;i++){
            result[m]=num_list[i];
            m++;
        }
        return result;
    }
}