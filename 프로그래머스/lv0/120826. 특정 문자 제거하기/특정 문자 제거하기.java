class Solution {
    public String solution(String s, String letter) {
 
        StringBuilder result = new StringBuilder();

        char[] arr = s.toCharArray();

        for(char ch : arr){
            if(ch!=letter.charAt(0)){
                result.append(ch);
            }
        }


        return result.toString();
    }
}