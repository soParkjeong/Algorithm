import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA_Knapsack {
	static int f_max;
	static int N;
	static int K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//T: 테케 개수
		int T=Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			//N:물건의 개수, K:가방의 부피
			String[]NK=br.readLine().trim().split(" ");
			N=Integer.parseInt(NK[0]);
			K=Integer.parseInt(NK[1]);
			ArrayList<int[]>list=new ArrayList<>();//[{4,5},{1,2},{3,2},{4,4},{2,3}] 이렇게 들어가게 함 
			for(int n=0;n<N;n++) {
				String[]str=br.readLine().trim().split(" ");
				int V=Integer.parseInt(str[0]);
				int C=Integer.parseInt(str[1]);
				list.add(new int[] {V,C});
			}//리스트에 추가
			
			f_max=0;
			int[] bits=new int[N];
			powerset(list,bits,0);
			
			System.out.println("#"+tc+" "+f_max);
		}
	}
	static void powerset(ArrayList<int[]>list, int[]bits, int depth) {
		if(depth==N) {
			int mg=0;//부피 합 저장용 
			int max=0;//가치 합 저장용
			
			for(int i=0;i<N;i++) {
				//기저조건 
				if(bits[i]==1) {
					mg+=list.get(i)[0];
					max+=list.get(i)[1];
				}
			}
			if(mg<=K) {//부피 합이 가방의 부피 이하인 경우 
				f_max=Math.max(f_max, max);
			}
			return;
		}
		
		bits[depth]=1;
		powerset(list,bits,depth+1);
		
		bits[depth]=0;
		powerset(list,bits,depth+1);
	}
}
