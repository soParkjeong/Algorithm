class Solution {
    public int solution(int a, int b, boolean flag) {
        int result=0;
        
        if(flag==true){
            result=a+b;
        }
        else{
            result=a-b;
        }
        return result;
    }
}