import java.util.Scanner;

public class SWEA_고대유적i {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] picture = new int[N][M];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    picture[i][j] = sc.nextInt();
                }
            }
            
            int max = 0;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (picture[i][j] == 1) {
                        for (int d = 0; d < 4; d++) {
                            int cnt = 1;
                            int nx = i;
                            int ny = j;
                            
                            while (true) {
                                nx += dx[d];
                                ny += dy[d];
                                
                                if (nx >= 0 && nx < N && ny >= 0 && ny < M && picture[nx][ny] == 1) {
                                    cnt++;
                                } else {
                                    break;
                                }
                            }
                            
                            max = Math.max(max, cnt);
                        }
                    }
                }
            }
            
            System.out.println("#" + tc + " " + max);
        }
        sc.close();
    }
}
