class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n + 1][n + 1];

        // 직접 승리 기록
        for (int[] r : results) {
            int a = r[0], b = r[1];
            win[a][b] = true;
        }

        // 전이(플로이드-워셜)
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (!win[i][k]) continue;              // 가지치기
                for (int j = 1; j <= n; j++) {
                    if (win[k][j]) win[i][j] = true;   // i > k, k > j => i > j
                }
            }
        }

        int answer = 0;

        // 순위 확정 가능한 선수 카운트
        for (int i = 1; i <= n; i++) {
            int known = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (win[i][j] || win[j][i]) known++;  // 관계가 한쪽으로라도 결정됨
            }
            if (known == n - 1) answer++;
        }

        return answer;
    }
}
