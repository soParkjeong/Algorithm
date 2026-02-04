import java.util.*;

class Solution {
    static final int MAX = 102; // 좌표 2배(최대 100) + 여유
    static int[][] board = new int[MAX + 1][MAX + 1];
    static boolean[][] visited = new boolean[MAX + 1][MAX + 1];

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        // 1) 모든 직사각형 영역을 채운다 (2배 좌표)
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    board[x][y] = 1;
                }
            }
        }

        // 2) 각 직사각형의 내부를 비운다 (테두리만 남기기)
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for (int x = x1 + 1; x <= x2 - 1; x++) {
                for (int y = y1 + 1; y <= y2 - 1; y++) {
                    board[x][y] = 0;
                }
            }
        }

        int sx = characterX * 2;
        int sy = characterY * 2;
        int tx = itemX * 2;
        int ty = itemY * 2;

        // 3) 테두리(=board==1)에서만 BFS
        int dist2 = bfs(sx, sy, tx, ty);

        // 4) 2배 좌표에서의 거리 -> 원래 거리
        return dist2 / 2;
    }

    static int bfs(int sx, int sy, int tx, int ty) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], d = cur[2];

            if (x == tx && y == ty) return d;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx > MAX || ny > MAX) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] != 1) continue; // 테두리만 이동

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, d + 1});
            }
        }
        return -1; // 문제 조건상 도달 가능
    }
}
