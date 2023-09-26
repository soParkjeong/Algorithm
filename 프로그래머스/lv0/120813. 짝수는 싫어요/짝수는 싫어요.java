class Solution {
    public int[] solution(int n) {
       
        int[] result;
        
        if(n%2==0){
        result=new int[n/2];
        }
        else{
        result=new int[(n/2)+1];
        }
        
        int index=0;
        for(int i=1;i<=n;i++){
            if(i%2!=0){
            result[index]=i;
                index++;
            }
        }
        return result;
    }
}