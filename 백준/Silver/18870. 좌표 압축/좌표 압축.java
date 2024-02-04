import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] xArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 중복 제거 및 정렬된 배열 생성
        int[] xArr2 = Arrays.stream(xArr.clone()).distinct().sorted().toArray();

        StringBuilder finalResult = new StringBuilder();

        for (int j = 0; j < N; j++) {
            int target = xArr[j];
            int count = countOccurrences(xArr2, target);

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
        return leftMostIdx;
    }

    private static int findLeftMostIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int leftMostIdx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                leftMostIdx = mid;
                right=mid-1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return leftMostIdx;
    }
}