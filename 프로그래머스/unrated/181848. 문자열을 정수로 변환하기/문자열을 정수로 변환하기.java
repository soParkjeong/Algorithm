class Solution {
    public int solution(String n_str) {
        char[]arr=n_str.toCharArray();
        int[]result=new int[arr.length];
        
        for(int i=0;i<arr.length;i++){
         result[i]=Character.getNumericValue(arr[i]);
        }
       
        int finalResult=arrayToInteger(result);
        return finalResult;
  
    }
    
   public int arrayToInteger(int[] digits) {
        int result = 0;
        int multiplier = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            result += digits[i] * multiplier;
            multiplier *= 10;
        }

        return result;
    }
}