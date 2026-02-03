class Solution {
    public boolean isTrionic(int[] nums) {
        //p,q 지점만 정하면 됨
        //증가하는 게 끊기면 그 때 p 정함
        //감소하는 게 끊기면 그 때 q 정함
        //q부터 n-1까지 계속 감소하는지만 체크 
        int n = nums.length;

        int i = 0;

        while (i + 1 < n && nums[i] < nums[i + 1]) i++;
        int p = i;

        if (p == 0) return false;

        while (i + 1 < n && nums[i] > nums[i + 1]) i++;
        int q = i;

        if (q == p) return false;

        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
            if (i == n - 1 && q < n - 1) {
                return true;
            }
        }
        return false;
    }
}
