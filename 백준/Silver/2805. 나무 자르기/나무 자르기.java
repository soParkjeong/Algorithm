import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        StringTokenizer tArr = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tArr.nextToken());
        }

        Arrays.sort(arr);
        int result = findMaxHeight(arr, N, M);
        System.out.println(result);

        br.close();
    }

    private static int findMaxHeight(int[] arr, int N, int M) {
        int start = 0;
        int end = arr[N - 1];
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long totalLength = 0;  // Use long to prevent integer overflow

            for (int i = 0; i < N; i++) {
                int cutLength = arr[i] - mid;
                if (cutLength > 0) {
                    totalLength += cutLength;
                }
            }

            if (totalLength >= M) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
