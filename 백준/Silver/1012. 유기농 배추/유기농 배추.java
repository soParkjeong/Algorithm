import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 배추밭의 가로길이
            int N = Integer.parseInt(st.nextToken()); // 배추밭의 세로길이
            int K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

            int[][] field = new int[M][N]; // 배추밭 초기화
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // 배추의 x좌표
                int Y = Integer.parseInt(st.nextToken()); // 배추의 y좌표
                field[X][Y] = 1; // 배추 심어진 위치 표시
            }

            int wormCount = countWorms(field);
            System.out.println(wormCount);
        }
    }

    private static int countWorms(int[][] field) {
        int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
        int[] dy = {0, 0, -1, 1};
        int count = 0; // 필요한 배추흰지렁이 수

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 1) { // 배추가 있으면
                    bfs(field, i, j); // BFS로 인접한 배추들을 모두 찾음
                    count++; // 배추흰지렁이 수 증가
                }
            }
        }
        return count;
    }

    private static void bfs(int[][] field, int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        field[startX][startY] = 0; // 방문한 배추 표시

        int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < field.length && ny >= 0 && ny < field[0].length && field[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    field[nx][ny] = 0; // 방문한 배추 표시
                }
            }
        }
    }
}
