import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int sc : scoville) pq.offer(sc);

        int count = 0;

        while (pq.peek() < K) {          // pq는 비어있지 않음(입력 길이 >= 1)
            if (pq.size() < 2) return -1; // 더 섞을 수 없음

            int min1 = pq.poll();
            int min2 = pq.poll();

            pq.offer(min1 + (min2 * 2));
            count++;
        }

        return count;
    }
}
