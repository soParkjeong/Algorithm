import java.util.*;

public class bj_1654_fin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); // 기존 랜선 개수
        int N = sc.nextInt(); // 필요한 랜선 개수
        
        int[] arr = new int[K];
        long max = 0; // 가장 긴 랜선 길이 저장
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
            max=Math.max(max, arr[i]);
        }
     
        
        long start = 1; // 최소 길이
        long end = max; // 최대 길이
        long result = 0; // 최적 랜선 길이 저장
        
        while (start <= end) {
            long mid = (start + end) / 2; // 중간 길이 계산
            int count = 0;
            
            for (int i = 0; i < K; i++) {
                count += arr[i] / mid; // mid 길이로 잘랐을 때 나오는 랜선 개수
            }
            
            if (count >= N) { // 필요한 개수보다 많으면
                result = mid; // 목 길이 갱신
                start = mid + 1; // 더 긴 길이를 시도
            } else { // 필요한 개수보다 적으면
                end = mid - 1; // 더 짧은 길이를 시도
            }
        }
        
        System.out.println(result);
    }
}
