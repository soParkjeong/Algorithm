class Solution {
    public int solution(String my_string) {
        char[]arr=my_string.toCharArray();
        int result=0;
        
        for(int i=0;i<arr.length;i++){
            if(Character.isDigit(arr[i])){
                result+=Character.getNumericValue(arr[i]);;
            }
        }
        return result;
    }
}