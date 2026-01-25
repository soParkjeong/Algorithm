import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());

            long[] dp = new long[10];

            // 길이 1 초기화
            for (int d = 0; d < 10; d++) {
                dp[d] = 1;
            }

            // 길이 2 ~ n
            for (int len = 2; len <= n; len++) {
                long sum = 0;
                for (int d = 0; d < 10; d++) {
                    sum += dp[d];
                    dp[d] = sum;
                }
            }

            long ans = 0;
            for (int d = 0; d < 10; d++) {
                ans += dp[d];
            }

            System.out.println(ans);
        }
    }
}
