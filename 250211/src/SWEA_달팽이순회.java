import java.io.*;
import java.util.*;

public class SWEA_달팽이순회 {
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; ++i)
        {
            int N = sc.nextInt();

            int[][] arr = new int[N][N];

            int r = 0, c = 0, cnt = 1;
            arr[r][c] = cnt; // 내 위치에 숫자 입력

            // 방향 전환
            int k = 0; 

            while (cnt != N*N) {
                //방향 정하기
                int nr = r + dr[k]; 
                int nc = c + dc[k];
                 
                if(0 > nr || nr >= N || 0 > nc || nc >= N || arr[nr][nc] != 0) {//벽의 끝에 부딪히거나 이미 숫자가 채워진 곳을 만날 때 까지 그 방향(k)로 계속 입력 
                    k = (k + 1) % 4; //만약에 벽에 부딪히면 방향 전환
                    continue;
                }

                arr[nr][nc] = ++cnt;//숫자를 +1씩 증가시키면서 계속 해당 방향으로 입력 
                r = nr;//현재 위치를 이동한 위치로 갱신 
                c = nc;//현재 위치를 이동한 위치로 갱신 
            }

            System.out.println("#"+i);
            for(int x = 0; x < N; x++)//1~N까지 입력되어야 하니까 0부터 시작해
            {
                for(int y = 0; y < N; y++)
                {
                    System.out.print(arr[x][y] + " ");
                }
                System.out.println();
            }
        }
    }
}