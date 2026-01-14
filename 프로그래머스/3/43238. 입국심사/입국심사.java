import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 0;
        long right = (long) times[times.length - 1] * (long) n; // 최악의 경우
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2; 
            long count = 0;

            // mid 시간 동안 처리 가능한 사람 수 계산
            for (int t : times) {
                count += mid / t;

                // n 이상이면 더 볼 필요 없음
                if (count >= n) break;
            }

            if (count >= n) {
                // mid 시간 안에 n명 처리 가능- 더 줄여도 됨
                answer = mid;
                right = mid - 1;
            } else {
                // mid 시간 안에 n명 처리 불가능- 시간 늘려야 함
                left = mid + 1;
            }
        }

        return answer;
    }
}
