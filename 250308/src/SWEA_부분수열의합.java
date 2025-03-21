import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_부분수열의합 {
	static int[]array;//원집합 
	static int N;
	static int K;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String[] str=br.readLine().split(" ");
			N=Integer.parseInt(str[0]);
			K=Integer.parseInt(str[1]);
			String[]arr=br.readLine().split(" ");
			array=new int[N];
			
			for(int i=0;i<N;i++) {
				array[i]=Integer.parseInt(arr[i]);
			}
			
			cnt=0;
			powerset(0,0);
			System.out.println("#"+tc+" "+cnt);
		}
	}
	static void powerset(int idx,int sum) {
		//종료 조건(기저 조건) 
		if(idx==N) {
			if(sum==K) {
				cnt++;//목표 합과 같으면 count 증가 
			}
			return;
		}
		
		//현재 원소를 포함하는 경우 
		powerset(idx+1,sum+array[idx]);

		//현재 원소를 포함하지 않는 경우 
		powerset(idx+1,sum);
	}
}
