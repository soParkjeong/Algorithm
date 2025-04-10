import java.io.*;
import java.util.*;

public class boj_1303 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().trim().split(" ");
        N = Integer.parseInt(NM[0]); // 열
        M = Integer.parseInt(NM[1]); // 행

        map = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
        	char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j];
            }
        }

        int cntW = 0;
        int cntB = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int size = bfs(i, j, map[i][j]);
                    if (map[i][j] == 'W') {
                    	cntW += size * size;
                    } else {
                    	cntB += size * size;
                    }
                }
            }
        }

        System.out.println(cntW + " " + cntB);
    }

    static int bfs(int x, int y, char team) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] == team) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}