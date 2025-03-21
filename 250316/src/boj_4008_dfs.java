import java.util.Scanner;

public class boj_4008_dfs {
    public static int max, min, N;
    public static int[] operator = new int[4];
    public static int[] arr; //얘는 건들지마
    public static String[] answerStr = new String[4]; //얘는 건들지마
    public static String[] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            arr = new int[N];
            answer = new String[N-1];
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                operator[i] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            answerStr[0] = "+";
            answerStr[1] = "-";
            answerStr[2] = "*";
            answerStr[3] = "/";
            comb(0);
            System.out.printf("#%d %d\n",t,max-min);
        }
    }
    //연산자의 순서만 정하면 됨
    //연산자의 개수를 나타낸 배열에서 안의 원소가 1이상이기만 하면 됨
    //사용한다면 그 해당 원소를 -1 해줘야함
    public static void comb(int depth) {
        if (depth == N - 1) {
            if (operator[0] < 0 &&
                    operator[1] < 0 &&
                    operator[2] < 0 &&
                    operator[3] < 0) {
                return;
            }
            int tmpResult = solution(arr, answer, N);
            if (tmpResult < min) {
                min = tmpResult;
            }

            if (tmpResult > max) {
                max = tmpResult;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) {
                continue;
            } else {
                answer[depth] = answerStr[i]; // 넣어줘
                operator[i]--; //골랐으니 하나 제거
                comb(depth + 1); //다음 depth로
                operator[i]++; // 전의 depth로 나왔으니 원상복구
            }
        }


    }

    public static int solution(int[] operator, String[] answerStr, int N) { //계산하는거
        int result = operator[0];

        for (int i = 0; i < N-1; i++) {
            String a = answerStr[i];
            int b = operator[i + 1];
            if (a.equals("+")) {
                result += b;
            } else if (a.equals("-")) {
                result -= b;
            } else if (a.equals("*")) {
                result *= b;
            } else {
                result /= b;
            }
        }
        return result;
    }
}
