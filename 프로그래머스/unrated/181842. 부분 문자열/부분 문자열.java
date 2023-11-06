class Solution {
    public int solution(String str1, String str2) {
      int finalResult=0;
      
    boolean result=str2.contains(str1);
        if(result==true){
            finalResult=1;
        }
        else{
            finalResult=0;
        }
        return finalResult;
    }
}