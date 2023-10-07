class Solution {
    public int solution(int a, int b) {
      String aStr=Integer.toString(a);
      String bStr=Integer.toString(b);
        
        int lengthA=aStr.length();
        int lengthB=bStr.length();
        
        int result1=(int)(a*Math.pow(10,lengthB)+b);
        int result2=(int)(b*Math.pow(10,lengthA)+a);
        int result=0;
        
        if(result1>result2||result1==result2){
            result=result1;
        }
        else{
            result=result2;
        }
        
        return (int)result;
    }
}