import java.util.*;

class Solution {

    boolean[] used;
    HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        used = new boolean[numbers.length()];

        // 모든 조합 생성
        for (int len = 1; len <= numbers.length(); len++) {
            dfs(numbers, "", len);
        }

        int count = 0;
        for (int num : set) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }

    // 순열 생성
    private void dfs(String numbers, String cur, int targetLen) {
        if (cur.length() == targetLen) {
            set.add(Integer.parseInt(cur));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (used[i]) continue;

            used[i] = true;
            dfs(numbers, cur + numbers.charAt(i), targetLen);
            used[i] = false;
        }
    }

    // 소수 여부
    private boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
