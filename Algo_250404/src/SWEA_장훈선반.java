import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_장훈선반 {
	//부분집합 
	static int N;
	static int B;
	static int[] comp;
	static int[] bits;//부분집합을 담을 배열 
	static int minDiff;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			String[]NB=br.readLine().trim().split(" ");
			N=Integer.parseInt(NB[0]);//점원 수 
			B=Integer.parseInt(NB[1]);//선반 높이 
			
			comp=new int[N];
			String[]str=br.readLine().trim().split(" ");
			for(int i=0;i<N;i++) {
				comp[i]=Integer.parseInt(str[i]);
			}//직원 배열에 담기 
			
			minDiff=Integer.MAX_VALUE;
			comb(0,0);
			
			System.out.println("#"+tc+" "+minDiff);
		}
	}
	static void comb(int depth,int sum) {
		//기저조건 
		if(depth==N) {
			if(sum>=B) {//합이 선반 높이보다 높을 때만 차이 최소 갱신 
				minDiff=Math.min(minDiff, sum-B);
			}
			return;
		}
		
		comb(depth+1,sum+comp[depth]);
		
		comb(depth+1,sum);
	}
}
