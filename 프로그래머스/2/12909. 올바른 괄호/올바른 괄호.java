class Solution {
    boolean solution(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                count++;
            } else { //닫는 괄호면
                count--;
                //여는 괄호가 없는데 닫는 괄호가 들어온 경우-음수가 되니까
                if (count < 0) {
                    return false; 
                }
            }
        }

        return count == 0;
    }
}
