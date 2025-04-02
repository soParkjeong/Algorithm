import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class SWEA_파핑파핑_je {
    static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
    private static int N, click;
    static boolean[][] visited;
    static char[][] input;
    static int[][] map;
    static boolean isok;
 
    static class Bomb {
        int x;
        int y;
 
        public Bomb(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
 
            N = Integer.parseInt(br.readLine().trim());
            input = new char[N][N];
            map = new int[N][N];
            visited = new boolean[N][N];
            isok = true;
            click = 0;
 
            for (int i = 0; i < N; i++) {
                String st = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    input[i][j] = st.charAt(j);
                }
            }
             
            for(int i =0; i < N; i++) {
                for(int j =0 ; j < N; j++) {
                    if (input[i][j] == '*') {
                        map[i][j] = -1;
                    } else if (input[i][j] == '.') {
                        checkbomb(i, j);
                    }
                }
            }
             
 
            // bfs : 0인 지점을 찾아서 queue에 넣고
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0 && !visited[i][j]) {
                        bfs(i, j);
                        click++;
                    }
                }
            }
             
 
            // 최종적으로 0이 아니고 지뢰가 아닌 숫자들이 써 있는 칸을 클릭해서 마무리
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != 0 && map[i][j] != -1 && map[i][j] != -2) {
                        click++;
                    }
                }
            }
 
            System.out.println("#" + tc + " " + click);
 
        } // tc
    }
 
    private static void bfs(int x, int y) {
        Queue<Bomb> queue = new LinkedList<>();
 
        queue.add(new Bomb(x, y));
        visited[x][y] = true;
 
        while (!queue.isEmpty()) {
            Bomb b = queue.poll();
             
            for (int d = 0; d < 8; d++) {
                int nx = b.x + dr[d];
                int ny = b.y + dc[d];
 
                if (nx < N && nx >= 0 && ny < N && ny >= 0 && !visited[nx][ny] && map[nx][ny] != -1) {
                    visited[nx][ny] = true;
                     
                     
                    if (map[nx][ny] == 0) {
                        queue.add(new Bomb(nx, ny));
                    }
                    map[nx][ny] = -2;
                }//범위 안 
 
            }
             
        }
 
    }
 
    private static void checkbomb(int r, int c) {
        int cnt = 0;
        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
 
            if (nr < N && nr >= 0 && nc < N && nc >= 0) {
                if(input[nr][nc] == '*') {
                    cnt++;  
                }
            }
 
        }
        map[r][c] = cnt;
    }
 
}