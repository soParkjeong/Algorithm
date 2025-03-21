import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class boj_1463 {
	static Map<Integer, Integer> memo = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine().trim());
		
		System.out.println(dp(N));
	}
	
	static int dp(int n) {
		int min=Integer.MAX_VALUE;
		
		if(n==1) return 0;
		
		if(memo.containsKey(n)) {
			return memo.get(n);
		}
		
		if(n%3==0) {
			min=Math.min(min,dp(n/3)+1);
		}
		
		if(n%2==0) {
			min=Math.min(min,dp(n/2)+1);
		}
		
		min=Math.min(min,dp(n-1)+1);
		
		int final_min=min;
		
		memo.put(n,final_min);
		
		return final_min;
	}
}
