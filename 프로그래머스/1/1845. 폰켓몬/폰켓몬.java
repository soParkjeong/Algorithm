import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int pick = nums.length / 2;

        // 서로 다른 폰켓몬 종류 수
        Set<Integer> types = new HashSet<>();
        for (int n : nums) types.add(n);

        // 최대 종류 수 = (서로 다른 종류 수) vs (뽑을 수 있는 마리 수) 중 작은 값
        return Math.min(types.size(), pick);
    }
}
