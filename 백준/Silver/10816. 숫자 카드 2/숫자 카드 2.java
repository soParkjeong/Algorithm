import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] intArr = new int[N];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(intArr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder finalResult = new StringBuilder();

        for (int j = 0; j < M; j++) {
            int target = Integer.parseInt(st.nextToken());
            int count = countOccurrences(intArr, target);

            finalResult.append(count).append(" ");
        }

        System.out.println(finalResult.toString().trim());

        br.close();
    }

    private static int countOccurrences(int[] arr, int target) {
        int leftMostIdx = findLeftMostIndex(arr, target);
        if (leftMostIdx == -1) {
            return 0;
        }

        int rightMostIdx = findRightMostIndex(arr, target);

        return rightMostIdx - leftMostIdx + 1;
    }

    private static int findLeftMostIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int leftMostIdx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                leftMostIdx = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return leftMostIdx;
    }

    private static int findRightMostIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int rightMostIdx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                rightMostIdx = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rightMostIdx;
    }
}
