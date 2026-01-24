import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        //가장 큰 합이 최소가 되려면
        //가장 큰 수는 가장 작은거랑 합쳐져야 하지 않나?
        //다음으로 큰 수는 다음으로 작은거랑...반복
        //그럼 일단 정렬
        //앞에꺼랑 뒤에꺼 합치는 거 반복 식으로 해서->그 중 max 반환
        Arrays.sort(nums);         

        int left=0;
        int right=nums.length-1;
        int answer=0;

        while(left<right){
            int pairSum=nums[left]+nums[right];
            if(pairSum>answer) answer=pairSum;

            left++;
            right--;
        }
        return answer;
    }
}
