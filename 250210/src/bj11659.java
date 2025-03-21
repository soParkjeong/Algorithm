import java.io.*;
import java.util.StringTokenizer;

public class bj11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());//입력된 한 줄을 공백을 기준으로 분리하는 역할
        //br.readLine()은 한 줄의 입력을 문자열로 가져옴
        //StringTokenizer은 공백을 기준으로 문자열을 나눠서 저장 
        int N = Integer.parseInt(st.nextToken());//공백을 기준으로 나눈 문자열 중 하나를 가져옴-> 정수형으로 변환  
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int x = a - 1; x < b; x++) {
                sum += arr[x];
            }
            System.out.println(sum);
        }

        br.close();
    }
}