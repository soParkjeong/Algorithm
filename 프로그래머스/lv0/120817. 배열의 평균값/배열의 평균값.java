class Solution {
    public double solution(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            total=total+num;
        }
        double average = (double) total / numbers.length;//numbers배열의 길이
        
        return average;
    }
}