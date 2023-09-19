class Solution {
    public int[] solution(int[] num_list) {
        int evenCount=0;
        int oddCount=0;
        
        for(int i=0;i<num_list.length;i++){
         if(num_list[i]%2==0){
             evenCount++;
         }
         else{
             oddCount++;
              }
        }
         int [] final_list={evenCount,oddCount};
            return final_list;
       
    }
}