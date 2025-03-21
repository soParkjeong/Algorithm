import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class boj_2579 {
	static int[] stair;
	static int cnt;
	static int T;
	static int max;
	static Map<Integer,Integer>memo=new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine().trim());
		
		stair=new int[T+1];
		
		for(int t=0;t<T;t++) {
			stair[t]=Integer.parseInt(br.readLine().trim());
		}
		
		int cnt=0;
		max=Integer.MIN_VALUE;
		System.out.println(dp(T,cnt));
		for(int i=0;i<T;i++) {
			System.out.println(memo.get(i));
		}
	
	}
	
	static int dp(int n,int cnt) {
		if(n==1) {
			if(cnt<2) {
				return stair[0];
			}else {
				return 0;
			}
		}
		if(n==0) return 0;
		
		if(memo.containsKey(n)) {
			return memo.get(n);
		}
		
		//System.out.println(n+" "+cnt);
		if(cnt<2){//연속된 계단 밟지 않도록 
			if(n-2>=0) {//범위 안넘어가도록 
				max=Math.max(dp(n-1,cnt+1) + stair[n-1], dp(n-2,cnt) + stair[n-2]);
			}else {//n-2<0이면 선택의 여지 없이 바로 앞칸으로 
				max=dp(n-1,cnt+1) + stair[n-1];
				//System.out.println(max);
			}
		}else {
			max = dp(n-2,cnt) + stair[n-2];
			//System.out.println(max);
		}
		
		memo.put(n,max);
		//System.out.println(memo.get(n));
		
		return max;
	}
} 
