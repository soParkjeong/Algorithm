import java.util.*;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);

            if (p == 2) { 
                ans[i] = -1;
                continue;
            }

            //연속된 1의 개수
            int r = 0;
            int P = p;
            while ((P & 1) == 1) {
                r++;
                P >>= 1;
            }

            //p-2의(r-1)승
            long x = (long) p - (long) Math.pow(2, r - 1)
;
            ans[i] = (int) x;
        }

        return ans;
    }
}
