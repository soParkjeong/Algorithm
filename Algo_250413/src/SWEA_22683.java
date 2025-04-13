import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_22683 {
    static int N;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0}; 
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y, dir, depth, cutLeft;
        Node(int x, int y, int dir, int depth, int cutLeft) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.depth = depth;
            this.cutLeft = cutLeft;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            int maxCut = Integer.parseInt(input[1]);

            map = new char[N][N];
            int sx = 0, sy = 0;

            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 'X') {
                        sx = i;
                        sy = j;
                    }
                }
            }

            System.out.println("#" + tc + " " + bfs(sx, sy, maxCut));
        }
    }

    static int bfs(int sx, int sy, int maxCut) {
        Queue<Node> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][N][4][maxCut + 1];

        q.offer(new Node(sx, sy, 0, 0, maxCut));
        visited[sx][sy][0][maxCut] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int depth = cur.depth;
            int cut = cur.cutLeft;

            // 도착
            if (map[x][y] == 'Y') return depth;

            // 전진
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                char next = map[nx][ny];

                // 이동 가능
                if ((next == 'G' || next == 'Y') && !visited[nx][ny][dir][cut]) {
                    visited[nx][ny][dir][cut] = true;
                    q.offer(new Node(nx, ny, dir, depth + 1, cut));
                }
                // 나무일 때 베고 이동
                if (next == 'T' && cut > 0 && !visited[nx][ny][dir][cut - 1]) {
                    visited[nx][ny][dir][cut - 1] = true;
                    q.offer(new Node(nx, ny, dir, depth + 1, cut - 1));
                }
            }

            // 좌회전
            int left = (dir + 3) % 4;
            if (!visited[x][y][left][cut]) {
                visited[x][y][left][cut] = true;
                q.offer(new Node(x, y, left, depth + 1, cut));
            }

            // 우회전
            int right = (dir + 1) % 4;
            if (!visited[x][y][right][cut]) {
                visited[x][y][right][cut] = true;
                q.offer(new Node(x, y, right, depth + 1, cut));
            }
        }

        return -1;
    }
}