import java.util.Arrays;
class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
     
       if(num2>num1){
       int count=num2-num1+1;
        
       int[] result=new int[count]; 
        
        for(int i=0;i<count;i++){
          result[i]=numbers[num1+i];
        }
        
        return result;
    }
    else{
        return new int[0];
    }
        
    
       
}
}

    