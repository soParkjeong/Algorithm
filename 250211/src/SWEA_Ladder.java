import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Ladder {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) { // 테스트 케이스 10개
            bf.readLine(); // 테스트 케이스 번호 읽기 (사용 안 함)

            int[][] arr = new int[100][100];

            // 사다리 배열 입력 받기
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0; // 최종 출발점 저장

            // 첫 번째 행(0행)에서 열 탐색
            for (int startCol = 0; startCol < 100; startCol++) {
                if (arr[0][startCol] == 1) { // 1인 곳에서 출발
                    int x = 0, y = startCol;
                    boolean[][] visited = new boolean[100][100]; // 방문 체크 배열

                    while (x < 99) { // 99행 도착할 때까지
                        visited[x][y] = true; // 방문 처리

                        // 🔹 **오른쪽 이동 가능하면 끝까지 이동**
                        if (y + 1 < 100 && arr[x][y + 1] == 1 && !visited[x][y + 1]) {
                            while (y + 1 < 100 && arr[x][y + 1] == 1) {
                                y++;
                                visited[x][y] = true;
                            }
                        }
                        // 🔹 **왼쪽 이동 가능하면 끝까지 이동**
                        else if (y - 1 >= 0 && arr[x][y - 1] == 1 && !visited[x][y - 1]) {
                            while (y - 1 >= 0 && arr[x][y - 1] == 1) {
                                y--;
                                visited[x][y] = true;
                            }
                        }
                        // 🔹 **좌우 이동이 끝나면 아래로 이동**
                        x++;

                        // 도착 지점(2) 도달 확인
                        if (arr[x][y] == 2) {
                            result = startCol; // 출발 열 저장
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}
