import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1018 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] chess = new char[N][M];

        // 체스판 입력 받기
        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                chess[i][j] = line.charAt(j);
            }
        }

        int minCnt = Integer.MAX_VALUE; // 최소 변경 횟수

        // 8×8 크기로 탐색
        for (int x = 0; x <= N - 8; x++) {
            for (int y = 0; y <= M - 8; y++) {
                int cntB = 0; // 'B' 시작 체스판 변경 횟수
                int cntW = 0; // 'W' 시작 체스판 변경 횟수

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        // (i, j) 위치에서의 예상 색상
                        if ((i + j) % 2 == 0) { // 짝수일 때
                            if (chess[x + i][y + j] != 'B') cntB++; // 'B' 시작일 때 다르면 변경
                            if (chess[x + i][y + j] != 'W') cntW++; // 'W' 시작일 때 다르면 변경
                        } else { // 홀수일 때
                            if (chess[x + i][y + j] != 'W') cntB++; // 'B' 시작일 때 다르면 변경
                            if (chess[x + i][y + j] != 'B') cntW++; // 'W' 시작일 때 다르면 변경
                        }
                    }
                }
                
                // 최소 변경 횟수 갱신
                minCnt = Math.min(minCnt, Math.min(cntB, cntW));
            }
        }

        System.out.println(minCnt);
    }
}


