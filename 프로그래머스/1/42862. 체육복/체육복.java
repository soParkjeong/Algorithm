import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        int[] clothes = new int[n + 1];
        for (int i = 1; i <= n; i++) clothes[i] = 1;

        for (int i = 0; i < lost.length; i++) clothes[lost[i]]--;
        for (int i = 0; i < reserve.length; i++) clothes[reserve[i]]++;

        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0) {
                // 앞번호에게 빌릴 수 있으면 빌림
                if (i - 1 >= 1 && clothes[i - 1] == 2) {
                    clothes[i - 1]--;
                    clothes[i]++;
                }
                // 뒷번호에게 빌림
                else if (i + 1 <= n && clothes[i + 1] == 2) {
                    clothes[i + 1]--;
                    clothes[i]++;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) count++;
        }
        return count;
    }
}
