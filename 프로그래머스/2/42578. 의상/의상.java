import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> cnt = new HashMap<>();

        // 종류별 개수
        for (String[] c : clothes) {
            String type = c[1];
            cnt.put(type, cnt.getOrDefault(type, 0) + 1);
        }

        // (종류별 개수 + 1)를 종류 수만큼 곱
        int ans = 1;
        for (int k : cnt.values()) {//반복문이 종류 수만큼 돎
            ans *= (k + 1);
        }

        // 아무것도 안 입는 경우: -1
        return ans - 1;
    }
}
