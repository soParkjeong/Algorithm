import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_IM_신뢰 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		
		for(int t=0;t<T;t++) {
			String[] line=br.readLine().trim().split("\\s+");
			int N=Integer.parseInt(line[0]);
			int[] B_arr=new int[N];
			int[] O_arr=new int[N];
			int B_idx=0;
			int O_idx=0;
			
			int cnt_B=0;
			int cnt_O=0;
			for(int i=1;i<=N*2;i+=2) {
				if(line[i].equals("B")) {
					B_arr[B_idx++]=Integer.parseInt(line[i+1])-1;
					cnt_B++;
				}else {
					O_arr[O_idx++]=Integer.parseInt(line[i+1])-1;
					cnt_O++;
				}
			}//B랑 O배열 완성 
			
			int B_sum=0;
			int B=0;
			B_sum=B_arr[0];
			//B로봇이 수행하는 시간 구하기
			for(int i=1;i<cnt_B;i++) {
				B_sum+=Math.abs(B_arr[i]-B_arr[i-1]);
			}
			B=B_sum+cnt_B;//B이동시간+종누르는시간
			//System.out.print(B);
			
			int O_sum=0;
			int O=0;
			O_sum=O_arr[0];
			//B로봇이 수행하는 시간 구하기
			for(int i=1;i<cnt_O;i++) {
				O_sum+=Math.abs(O_arr[i]-O_arr[i-1]);
			}
			O=O_sum+cnt_O;//B이동시간+종누르는시간
			//System.out.print(O);
			
			//B랑 O중에서 더 오래 걸리는 시간
			int final_result=Math.max(B, O);
			
			//B와 O의 같은 위치에 종이 있는 경우 세기 
			int cnt=0;
			for(int i=0;i<cnt_B;i++) {
				for(int j=0;j<cnt_O;j++) {
					if(B_arr[i]==O_arr[j]) {
						cnt++;
					}
				}
			}
			//System.out.print(cnt);
			System.out.println("#"+(t+1)+" "+(final_result+cnt));
		}
	}
}
