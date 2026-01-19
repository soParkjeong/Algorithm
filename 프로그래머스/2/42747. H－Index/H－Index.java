import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] arr = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            arr[i] = citations[i];
        }

        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < i + 1) {
                return i;
            }
        }
        
        return arr.length;
    }
}
