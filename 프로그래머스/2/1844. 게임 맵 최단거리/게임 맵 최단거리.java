import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 거리 저장
        int[][] dist = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        if (maps[0][0] == 0) return -1;

        dist[0][0] = 1;           
        q.offer(new int[]{0, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                // 범위 밖
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                // 벽
                if (maps[nr][nc] == 0) continue;
                // 이미 방문
                if (dist[nr][nc] != 0) continue;

                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }

        // 도착점까지의 최단거리
        int ans = dist[n - 1][m - 1];
        return ans == 0 ? -1 : ans;
    }
}
