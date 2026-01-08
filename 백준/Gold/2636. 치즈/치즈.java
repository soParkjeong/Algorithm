import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] cheese;

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        cheese = new int[N][M];
        int totalCheese = 0; // 전체 치즈 개수 카운트

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(str[j]);
                if (cheese[i][j] == 1) totalCheese++; // 치즈 개수 세기
            }
        }

        int time = 0;
        int lastCheese = totalCheese;

        while (totalCheese > 0) {//치즈가 다 녹을 때까지 반복 돌리기 
            time++;//걸리는 시간 
            lastCheese = totalCheese; // 녹기 직전 치즈 개수 저장

            airBfs(); // 외부 공기 체크
            totalCheese -= cheeseBfs(); // 치즈 녹이기
        }

        System.out.println(time);
        System.out.println(lastCheese);
    }

    // 외부 공기 BFS 탐색
    static void airBfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new Node(0, 0));//시작점 넣기 
        visited[0][0] = true;
        cheese[0][0] = -1; // 외부 공기 표시

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && cheese[nx][ny]<=0) { // 공기라면 탐색
                        cheese[nx][ny] = -1;//외부 공기는 -1로 바꿔주기 
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;//방문처리 
                    }
                }
            }
        }
    }

    // 치즈 녹이기
    static int cheeseBfs() {
        Queue<Node> meltQueue = new LinkedList<>();
        int meltedCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheese[i][j] == 1) { // 치즈일 경우
                    int airTouch = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            if (cheese[nx][ny] == -1) { // 외부 공기와 맞닿았는지 체크
                                airTouch++;
                            }
                        }
                    }

                    if (airTouch > 0) {
                        meltQueue.add(new Node(i, j));
                        meltedCount++;//녹은 치즈 개수 세기 
                    }
                }
            }
        }

        while (!meltQueue.isEmpty()) {
            Node node = meltQueue.poll();
            cheese[node.x][node.y] = -1; // 녹은 치즈를 외부 공기로 변경
        }

        return meltedCount; //녹은 치즈 개수 반환
    }
}