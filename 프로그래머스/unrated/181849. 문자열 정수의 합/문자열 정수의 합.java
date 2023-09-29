class Solution {
    public int solution(String num_str) {
        char[] arr=num_str.toCharArray();
        int[]numArr=new int[arr.length];
        int sum=0;
        
        for(int i=0;i<arr.length;i++){
           numArr[i]=Integer.parseInt(String.valueOf(arr[i]));
            sum+=numArr[i];
        }
        return sum;
    }
}