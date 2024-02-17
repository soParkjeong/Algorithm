import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람의 수 입력
        int N = Integer.parseInt(br.readLine());

        // 각 사람이 돈을 인출하는데 걸리는 시간 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] times = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        // 각 사람이 돈을 인출하는데 필요한 시간의 합을 최소로 만들기 위해 오름차순 정렬
        Arrays.sort(times);

        // 각 사람이 돈을 인출하는데 필요한 시간의 합 계산
        int sum = 0;
        int waiting = 0; // 각 사람이 이전 사람이 돈을 인출하는데 기다리는 시간
        for (int i = 0; i < N; i++) {
            sum += waiting + times[i]; // 기다리는 시간과 현재 사람이 돈을 인출하는데 걸리는 시간을 더함
            waiting += times[i]; // 다음 사람이 기다리는 시간 갱신
        }

        // 결과 출력
        System.out.println(sum);
    }
}
