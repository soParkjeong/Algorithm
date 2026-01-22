import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n=nums.length;
        int cnt=0;

        while(true){
            boolean sort=true;

            for(int i=0;i<n-1;i++){
                if(nums[i]>nums[i+1]){
                    sort=false;
                    break;
                }
            }

            if(sort) break;

            int idx=0;
            int min_sum=Integer.MAX_VALUE;

            for(int i=0;i<n-1;i++){
                int sum=nums[i]+nums[i+1];
                if(min_sum>sum){//같을 때도 갱신하면, 가장 왼쪽인걸 보존 할 수 없으니까
                    min_sum=sum;
                    idx=i;
                }
            }

            nums[idx] = min_sum;
            for (int j = idx+1; j < n-1; j++) {
                nums[j] = nums[j + 1];
            }
            n--;     
            cnt++;
        }

        return cnt;
    }
}