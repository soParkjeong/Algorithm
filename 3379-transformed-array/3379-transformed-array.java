class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int move = nums[i];

            if (move == 0) {
                result[i] = 0;
                continue;
            }

            int nextIndex = (i + move) % n;

            // Java 음수 mod 보정
            if (nextIndex < 0) {
                nextIndex += n;
            }

            result[i] = nums[nextIndex];
        }

        return result;
    }
}
