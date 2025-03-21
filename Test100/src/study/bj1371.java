package study;

import java.util.*;

public class bj1371 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[26]; // 알파벳 소문자 카운트 배열

        while (sc.hasNextLine()) { // 🔥 EOF까지 한 줄씩 입력 받기
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch >= 'a' && ch <= 'z') { // 🔥 소문자인 경우만 카운트
                    cnt[ch - 'a']++;
                }
            }
        }

        // 최대 빈도수 찾기
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, cnt[i]);
        }

        // 최대 빈도 문자를 알파벳 순서대로 출력
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == max) {
                System.out.print((char) (i + 'a'));
            }
        }
        System.out.println(); // 줄 바꿈 추가
    }
}