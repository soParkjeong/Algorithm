import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) arr[i] = String.valueOf(numbers[i]);

        // (b+a) vs (a+b) 비교로 내림차순 정렬
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // 모두 0인 경우 "0" 처리 (예: [0,0,0])
        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }
}
