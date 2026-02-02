import java.util.*;

class Solution {

    // TreeMap을 이용한 "정렬 멀티셋"
    static class MultiSet {
        TreeMap<Long, Integer> map = new TreeMap<>();
        long sum = 0;   // 담긴 원소들의 합
        int size = 0;   // 담긴 원소 개수

        void add(long x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            sum += x;
            size++;
        }

        void remove(long x) {
            int c = map.get(x);
            if (c == 1) map.remove(x);
            else map.put(x, c - 1);
            sum -= x;
            size--;
        }

        boolean contains(long x) {
            return map.containsKey(x);
        }

        long first() { return map.firstKey(); } // 최소값
        long last()  { return map.lastKey(); }  // 최대값
    }

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int need = k - 1;        // nums[0] 제외하고 추가로 선택해야 할 시작점 개수
        int win = dist + 1;      // i1 고정 시 후보 구간 길이 = dist+1

        // i1 = i 일 때 윈도우는 [i .. i+dist]
        // i+dist <= n-1 => i <= n-1-dist => i <= n-win
        int maxI = n - win;      // i의 최댓값

        MultiSet small = new MultiSet(); // 항상 "가장 작은 need개" 유지
        MultiSet large = new MultiSet(); // 나머지

        // 초기 윈도우: i=1 => [1 .. 1+dist] = [1 .. win]
        for (int idx = 1; idx <= win; idx++) {
            addNumber(nums[idx], small, large, need);
        }
        rebalance(small, large, need);

        long best = small.sum;

        // 슬라이딩: i=2..maxI
        for (int i = 2; i <= maxI; i++) {
            int outIdx = i - 1;     // 윈도우에서 빠지는 인덱스
            int inIdx = i + dist;   // 새로 들어오는 인덱스

            removeNumber(nums[outIdx], small, large);
            addNumber(nums[inIdx], small, large, need);
            rebalance(small, large, need);

            best = Math.min(best, small.sum);
        }

        return (long) nums[0] + best;
    }

    private void addNumber(long x, MultiSet small, MultiSet large, int need) {
        if (small.size < need) {
            small.add(x);
            return;
        }
        if (need > 0 && small.size > 0 && x < small.last()) {
            long mv = small.last();
            small.remove(mv);
            large.add(mv);
            small.add(x);
        } else {
            large.add(x);
        }
    }

    private void removeNumber(long x, MultiSet small, MultiSet large) {
        if (small.contains(x)) small.remove(x);
        else large.remove(x);
    }

    private void rebalance(MultiSet small, MultiSet large, int need) {
        while (small.size < need) {
            long mv = large.first();
            large.remove(mv);
            small.add(mv);
        }
        while (small.size > need) {
            long mv = small.last();
            small.remove(mv);
            large.add(mv);
        }
        if (need == 0) return;

        while (small.size > 0 && large.size > 0 && small.last() > large.first()) {
            long a = small.last();
            long b = large.first();
            small.remove(a);
            large.remove(b);
            small.add(b);
            large.add(a);
        }
    }
}
