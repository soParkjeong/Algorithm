class Solution {
    public int solution(int[] num_list) {
        int finalResult=0;
        int result1=1;
        int result2=0;
        
        if(num_list.length<=10){
         for(int i=0;i<num_list.length;i++){
             result1*=num_list[i];
         }
        }
        else{
            for(int i=0;i<num_list.length;i++){
             result2+=num_list[i];
         }
        }
        if(num_list.length<=10){
            finalResult=result1;
        }
        else{
            finalResult=result2;
        }
        return finalResult;
    }
}