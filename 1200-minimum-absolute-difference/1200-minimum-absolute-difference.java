import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        //일단 정렬
        //슬라이딩 윈도우로 min 값 갱신
        //다시 반복문 돌면서 차이가 min인 원소 쌍 List에 저장->반환
        Arrays.sort(arr);

        int min_diff=Integer.MAX_VALUE;

        for(int i=0;i<arr.length-1;i++){
            int diff=arr[i+1]-arr[i];
            min_diff=Math.min(diff,min_diff);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]==min_diff){
                List<Integer> result=new ArrayList<>();
                result.add(arr[i]);
                result.add(arr[i+1]);
                ans.add(result);
            }
        }
        return ans;
    }
}