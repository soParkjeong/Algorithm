import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n=triangle.length;
        int[][]dp=new int[n][n];
        dp[0][0]=triangle[0][0];
        
        for(int depth=1;depth<n;depth++){
            //왼쪽 끝
            dp[depth][0]=dp[depth-1][0]+triangle[depth][0];
            
            //가운데 원소만, 양 끝빼고
            for(int c=1;c<=triangle[depth].length-2;c++){
                dp[depth][c]=Math.max(dp[depth-1][c-1],dp[depth-1][c])+triangle[depth][c];
            }
            
            //오른쪽 끝
            dp[depth][depth]=dp[depth-1][depth-1]+triangle[depth][depth];       
        }
        
        int answer = 0;
        for(int c=0;c<n;c++) answer=Math.max(answer,dp[n-1][c]);
        return answer;
    }
}