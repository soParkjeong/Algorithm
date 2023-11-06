class Solution {
    public int[] solution(int[] arr, int n) {
        int[]result=new int[arr.length];
        int l=arr.length;
        int k=0;
        
        if(l%2!=0){
            for(int i=0;i<arr.length;i++){
                if(k%2==0){
                    result[k]=arr[i]+n;
                    k++;
                }
                else{
                result[k]=arr[i];
                k++;
                }
            }
        }
            else{
               for(int i=0;i<arr.length;i++){
                if(k%2!=0){
                    result[k]=arr[i]+n;
                    k++;
                }
                else{
                result[k]=arr[i];
                k++;
                }
             
            }
            
        }
        return result;
    }
}