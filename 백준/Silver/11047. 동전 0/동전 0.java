import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 동전의 종류 수
        int K = Integer.parseInt(st.nextToken()); // 만들어야 하는 가치의 합
        int[] coins = new int[N];

        // 동전의 가치 입력
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 가치의 합을 만들 때 필요한 동전의 최소 개수 계산
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K == 0) break; // 가치의 합이 0이면 종료

            if (K >= coins[i]) { // 현재 동전의 가치가 가치의 합보다 작거나 같으면 사용
                count += K / coins[i];
                K %= coins[i];
            }
        }

        System.out.println(count);
    }
}
