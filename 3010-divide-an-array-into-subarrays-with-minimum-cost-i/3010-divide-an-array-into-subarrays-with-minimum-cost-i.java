import java.util.*;

class Solution {
    public int minimumCost(int[] nums) {
        //원래 nums배열 순서 유지-정렬 안됨
        //그러면 첫 비용은 nums[0]
        //나머지는 걍 정렬해서 최솟값 2개 뽑기
        int ans=nums[0];
        
        Arrays.sort(nums, 1, nums.length);
        
        for(int i=1;i<3;i++){
            ans+=nums[i];
        }
        return ans;
    }
}