import java.util.*;

class Solution {
    public int minimumCost(int[] nums) {
        //원래 nums배열 순서 유지-정렬 안됨
        //그러면 첫 비용은 무조건 nums[0]
        //나머지는 최솟값 2개 뽑기
        //정렬 안쓰는 방식
        int ans=nums[0];
        
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;

        for (int i= 1; i< nums.length; i++) {
            int x= nums[i];

            if (x<min1) {      
                min2=min1;       
                min1=x;
            } else if (x<min2) { 
                min2=x;
            }
        }
        ans+=(min1+min2);
        return ans;
    }
}