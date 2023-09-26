class Solution {
    public int solution(int n) {
        int count=0;
        
        for(int i=1;i<=1000;i++){
            if(i*i==n){
                count++;
            }
        }
        
        int result=0;
        if(count>0){
            result=1;
        }
        else{
            result=2;
        }
         return result;
        }
}