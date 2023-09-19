import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
       
        int a=sides[0];
        int b=sides[1];
        int c=sides[2];
        
        if(a+b>c){
            return 1;
        }
        else{
            return 2;
        }
    }
}
