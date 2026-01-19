class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        // ps[i][j] = mat[0..i-1][0..j-1]의 합
        int[][] ps = new int[m + 1][n + 1];

        // 🔹 교과서 공식 그대로
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] =
                        ps[i - 1][j]      // 위
                      + ps[i][j - 1]      // 왼쪽
                      - ps[i - 1][j - 1]  // 겹친 부분
                      + mat[i - 1][j - 1];// 현재 칸
            }
        }

        int left = 1, right = Math.min(m, n);
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canMake(ps, m, n, mid, threshold)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canMake(int[][] ps, int m, int n, int len, int threshold) {
        for (int r = 0; r + len <= m; r++) {
            for (int c = 0; c + len <= n; c++) {
                int sum =
                        ps[r + len][c + len]
                      - ps[r][c + len]
                      - ps[r + len][c]
                      + ps[r][c];

                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
