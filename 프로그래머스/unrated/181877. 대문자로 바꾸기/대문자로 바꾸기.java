class Solution {
    public String solution(String myString) {
        char[] arrMyString = myString.toCharArray();
        StringBuilder upperMyString = new StringBuilder();

        for (char ch : arrMyString) {
            char result = Character.toUpperCase(ch);
            upperMyString.append(result); // 대문자로 변환한 문자를 StringBuilder에 추가
        }
        
        return upperMyString.toString(); // StringBuilder를 문자열로 변환하여 반환
    }
}