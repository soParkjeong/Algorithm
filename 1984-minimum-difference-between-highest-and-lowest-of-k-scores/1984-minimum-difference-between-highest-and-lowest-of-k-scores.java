import java.util.*;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        //nums에서 k개를 뽑아서 k개 중 최대랑 최소의 diff가 min이 되도록
        //어제 문제랑 비슷한 맥락이네
        //정렬해서 한칸씩 밀면서 보자 슬라이딩 윈도우 ㄱㄱ
        Arrays.sort(nums);
        int minDiff=Integer.MAX_VALUE;

        for(int i=0;i<=nums.length-k;i++){
            int min=nums[i];
            int max=nums[i+k-1];
            int diff=max-min;
            minDiff=Math.min(diff,minDiff);
        }

        return minDiff;
    }
}