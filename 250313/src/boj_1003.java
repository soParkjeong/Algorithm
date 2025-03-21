import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1003 {
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int n=Integer.parseInt(br.readLine().trim());
			
			int[][]dp=new int[41][2];
			
			//초기화 
			dp[0][0]=1;
			dp[0][1]=0;
			
			dp[1][0]=0;
			dp[1][1]=1;
			
			//for문 돌면서 피보나치 계산 
			for(int i=2;i<=n;i++) {
				dp[i][0]=dp[i-1][0]+dp[i-2][0];
				dp[i][1]=dp[i-1][1]+dp[i-2][1];
			}
			
			
			System.out.println(dp[n][0]+" "+dp[n][1]);
		}
	}
}
