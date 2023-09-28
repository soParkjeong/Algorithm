class Solution {
    public String solution(String my_string, int n) {
        char[] arr=my_string.toCharArray();
        char[]result=new char[n];
        int k=0;
        
        for(int i=arr.length-n;i<arr.length;i++){
            result[k]=arr[i];
            k++;
        }
        
        String resultString=new String(result);
        
        return resultString;
    }
}