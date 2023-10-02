class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int length1=arr1.length;
        int length2=arr2.length;
        int result=0;
        int sum1=0;
        int sum2=0;
        
        if(length1!=length2){
            if(length1>length2){
                result=1;
            }
            else if(length1<length2){
                result=-1;
            }
            else{
                result=0;
            }
            }
       
        else{
            for(int i=0;i<arr1.length;i++){
                sum1+=arr1[i];
                sum2+=arr2[i];
                if(sum1>sum2){
                    result=1;
                }
                else if(sum1<sum2){
                    result=-1;
                }
                else{
                    result=0;
                }
            }
        }
                return result;
            }
        }
 