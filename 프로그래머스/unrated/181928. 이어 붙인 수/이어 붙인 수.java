public class Solution {
    public int solution(int[] num_list) {
        String oddString = ""; // 홀수를 이어붙인 문자열
        String evenString = ""; // 짝수를 이어붙인 문자열

        for (int num : num_list) {
            if (num % 2 != 0) {
                // 홀수인 경우, 홀수 문자열에 추가
                oddString += num;
            } else {
                // 짝수인 경우, 짝수 문자열에 추가
                evenString += num;
            }
        }

        // 홀수 문자열과 짝수 문자열을 정수로 변환하여 합산
        int oddSum = Integer.parseInt(oddString);
        int evenSum = Integer.parseInt(evenString);

        return oddSum + evenSum; // 홀수와 짝수 합의 결과 반환
    }
}