import java.util.Arrays;
class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        int k=0;
        int[]result=new int[num_list.length-5];
        for(int i=5;i<num_list.length;i++){
          result[k]=num_list[i];
            k++;
        }
        return result;
    }
}