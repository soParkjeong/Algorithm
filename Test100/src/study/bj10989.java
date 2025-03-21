package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기 위한 BufferedReader
        int T = Integer.parseInt(br.readLine()); // 한 줄 입력을 받고 정수 변환

        int[] arr = new int[T];

        for (int t = 0; t < T; t++) {
            arr[t] = Integer.parseInt(br.readLine()); // 한 줄 입력을 받아 배열에 저장
        }

        Arrays.sort(arr); // 배열 정렬 (버블 정렬 대신 사용)

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append("\n"); // 결과를 StringBuilder에 저장 (출력 최적화)
        }

        System.out.print(sb.toString()); // 한 번에 출력 (속도 개선)
    }
}
