import java.util.Arrays;
class Solution {
    public int solution(int[] numbers) {
        
        Arrays.sort(numbers);
        int i=numbers.length-1;
        int max=numbers[i];
        int sMax=numbers[i-1];
        int result=max*sMax;
        
        return result;
        }
    }
