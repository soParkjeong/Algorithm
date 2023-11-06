class Solution {
    public int[] solution(int[] arr) {
      int[]result=new int[arr.length];
        int k=0;
        
      for(int i=0;i<arr.length;i++){
          if(arr[i]>=50&&arr[i]%2==0){
              result[k]=arr[i]/2;
              k++;
          }
          else if(arr[i]<50&&arr[i]%2!=0){
              result[k]=arr[i]*2;
              k++;
          }
          else{
              result[k]=arr[i];
              k++;
          }
      }
        return result;
    }
}