class Solution {
    public int solution(int[][] sizes) {
        int max_x = 0;
        int max_y = 0;

        for (int i = 0; i < sizes.length; i++) {
            int x = sizes[i][0];
            int y = sizes[i][1];

            int big = (x > y) ? x : y;     // 큰 쪽
            int small = (x > y) ? y : x;   // 작은 쪽

            if (big > max_x) max_x = big;
            if (small > max_y) max_y = small;
        }

        return max_x * max_y;
    }
}
