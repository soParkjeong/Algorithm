import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_등산로조성 {
    static int N, K, maxHeight, result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);

            map = new int[N][N];
            visited = new boolean[N][N];
            maxHeight = 0;
            result = 0;

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                    maxHeight = Math.max(maxHeight, map[i][j]);
                }
            }

            // 모든 최대 높이에서 출발
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxHeight) {// 최대 높이인 곳을 시작점으로 dfs 돌리자
                        visited[i][j] = true;
                        dfs(i, j, 1, false);// max 갱신
                        visited[i][j] = false;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    static void dfs(int x, int y, int length, boolean cut) {
    	result = Math.max(result, length);

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

            if (map[nx][ny] < map[x][y]) {
                visited[nx][ny] = true;
                dfs(nx, ny, length + 1, cut);
                visited[nx][ny] = false;
            } else if (!cut && map[nx][ny] - K < map[x][y]) {
                int original = map[nx][ny];
                map[nx][ny] = map[x][y] - 1; // 깎기
                visited[nx][ny] = true;
                dfs(nx, ny, length + 1, true);
                visited[nx][ny] = false;
                map[nx][ny] = original; // 복구
            }
        }
    }
}