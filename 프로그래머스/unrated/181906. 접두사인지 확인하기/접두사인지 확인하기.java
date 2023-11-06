class Solution {
    public int solution(String my_string, String is_prefix) {
        int p=is_prefix.length();
        int m=my_string.length();
        int result=0;
        
   if(p<=m){
   String newString=my_string.substring(0,p);
        if(newString.equals(is_prefix)){
            result=1;
        }
        else{
            result=0;
        }
   }
        return result;
    }
}