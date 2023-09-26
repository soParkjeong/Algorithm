import java.util.Arrays;
class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        int a=array.length;
        
        return array[a/2];
    }
}