import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_IM_러시아국기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		
		for(int t=0;t<T;t++) {
			String[] str=br.readLine().trim().split(" ");
			int N=Integer.parseInt(str[0]);
			int M=Integer.parseInt(str[1]);
			char[][] arr=new char[N][M];
			for(int i=0;i<N;i++) {
				char[]line=br.readLine().trim().toCharArray();
				for(int j=0;j<M;j++) {
					arr[i][j]=line[j];
				}
			}//배열 완성
			
			int idx_B=0;
			int idx_R=0;
			int idx_W=0;
			int f_cnt=0;
			int min=Integer.MAX_VALUE;
			for(int i=2;i<=N-1;i++) {//빨강 시작점 i 
				for(int k=1;k<i;k++) {//파랑 시작점 k
						idx_B=0;
						idx_R=0;
						idx_W=0;
						f_cnt=0;//초기화 
						
						int W=0;
						int B=k;
						int R=i;
						
						while(W<B) {
							idx_W=0;
							while(idx_W<M) {
								if(arr[W][idx_W]!='W') {
									f_cnt++;
								}
								idx_W++;
							}
							W++;
						}
						
						while(B<R) {
							idx_B=0;
							while(idx_B<M) {
								if(arr[B][idx_B]!='B') {
									f_cnt++;
								}
								idx_B++;
							}
							B++;
						}
						
						while(R<N) {
							idx_R=0;
							while(idx_R<M) {
								if(arr[R][idx_R]!='R') {
									f_cnt++;
								}
								idx_R++;
							}
							R++;
						}
					min=Math.min(min,f_cnt);
				}
			}
			System.out.println("#"+(t+1)+" "+(min));
		}	
	}
}