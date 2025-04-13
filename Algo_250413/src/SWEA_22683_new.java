import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_22683_new {
    static int N;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0}; // ↑ → ↓ ←
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y, dir, depth, cut;
        Node(int x, int y, int dir, int depth, int cut) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.depth = depth;
            this.cut = cut;
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
        q.offer(new Node(sx, sy, 0, 0, 0));
        visited[sx][sy][0][0] = true;

        int minDepth = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 도착지 도달
            if (map[cur.x][cur.y] == 'Y') {
                minDepth = Math.min(minDepth, cur.depth);
                continue; // 더 짧은 경로 있을 수도 있음
            }

            // 전진
            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                char next = map[nx][ny];

                // 그냥 이동
                if ((next == 'G' || next == 'Y') && !visited[nx][ny][cur.dir][cur.cut]) {
                    visited[nx][ny][cur.dir][cur.cut] = true;
                    q.offer(new Node(nx, ny, cur.dir, cur.depth + 1, cur.cut));
                }

                // 나무 베고 이동
                if (next == 'T' && cur.cut < maxCut && !visited[nx][ny][cur.dir][cur.cut + 1]) {
                    visited[nx][ny][cur.dir][cur.cut + 1] = true;
                    q.offer(new Node(nx, ny, cur.dir, cur.depth + 1, cur.cut + 1));
                }
            }

            // 좌회전
            int left = (cur.dir + 3) % 4;
            if (!visited[cur.x][cur.y][left][cur.cut]) {
                visited[cur.x][cur.y][left][cur.cut] = true;
                q.offer(new Node(cur.x, cur.y, left, cur.depth + 1, cur.cut));
            }

            // 우회전
            int right = (cur.dir + 1) % 4;
            if (!visited[cur.x][cur.y][right][cur.cut]) {
                visited[cur.x][cur.y][right][cur.cut] = true;
                q.offer(new Node(cur.x, cur.y, right, cur.depth + 1, cur.cut));
            }
        }
        
        if(minDepth==Integer.MAX_VALUE) {
        	return -1;
        }else {
        	return minDepth;
        }
    }
}