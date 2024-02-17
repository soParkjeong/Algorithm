import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int idx = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max <= arr[i]) {
                max = arr[i];
                idx = i;
            }
        }

        int ans = 0;

        // 가장 큰 값의 오른쪽에 있는 모든 원소들과의 합 계산
        for (int i = idx + 1; i < n; i++) {
            ans += (arr[idx] + arr[i]);
        }

        // 가장 큰 값의 왼쪽에 있는 모든 원소들과의 합 계산
        for (int i = idx - 1; i >= 0; i--) {
            ans += (arr[idx] + arr[i]);
        }

        System.out.println(ans);
    }
}
