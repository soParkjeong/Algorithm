import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_Ladder1_복습 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 0; T < 10; T++) {
            int t = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                }
            }

            int start = 0;
            for (int j = 0; j < 100; j++) {
                if (arr[0][j] == 1) { // 시작점 찾기
                    int x = 0, y = j;
                    boolean[][] visited = new boolean[100][100];

                    while (x < 99) { // 아래로 내려가며 탐색
                        visited[x][y] = true;

                        if (y > 0 && arr[x][y - 1] == 1 && !visited[x][y - 1]) { // 왼쪽
                            y--;
                        } else if (y < 99 && arr[x][y + 1] == 1 && !visited[x][y + 1]) { // 오른쪽
                            y++;
                        } else { // 아래
                            x++;
                        }
                    }

                    if (arr[x][y] == 2) { // 도착지점 발견
                        start = j;
                        break;
                    }
                }
            }

            System.out.println("#" + t + " " + start);
        }
    }
}
