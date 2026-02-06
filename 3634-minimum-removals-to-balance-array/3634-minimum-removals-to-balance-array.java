import java.util.*;

class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int best = 1; // 남길 수 있는 최대 길이
        int r = 0;

        for (int l = 0; l < n; l++) {
            if (r < l) r = l;

            while (r < n) {
                long minVal = nums[l];
                long maxVal = nums[r];
                if (maxVal <= minVal * (long) k) {
                    r++;
                } else {
                    break;
                }
            }

            // 현재 l에서 가능한 r은 "조건 깨기 직전"이라서 r-1까지 유효
            best = Math.max(best, r - l);
        }

        return n - best;
    }
}
