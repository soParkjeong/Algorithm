import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_IM_파리퇴치3 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String[] NM=br.readLine().split(" ");
			int N=Integer.parseInt(NM[0]);
			int M=Integer.parseInt(NM[1]);
			int[][]n_arr=new int[N][N];
			
			for(int i=0;i<N;i++) {
				String[] line=br.readLine().split(" ");
				for(int j=0;j<N;j++){
					n_arr[i][j]=Integer.parseInt(line[j]);
				}//배열 완성 
			}
			
			int sum1=0;//+방향 
			int sum2=0;//X 방향 
			int[][] max=new int[N][N];//두 방향 중 최댓값 저장 
			int f_max=0;//최종 최댓값 저장 
			
			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					
					sum1=0;
					sum2=0;
					
					int[]dr= {-1,1,0,0};
					int[]dc= {0,0,-1,1};
					for(int k=1;k<M;k++) {
						for(int idx=0;idx<4;idx++) {
							int new_x=x+dr[idx]*k;
							int new_y=y+dc[idx]*k;
							if(new_x>=0 && new_x<N && new_y>=0 && new_y<N) {
								sum1+=n_arr[new_x][new_y];
							}
						}
					}
					sum1+=n_arr[x][y];
					
					int[]d_dr= {-1,1,-1,1};
					int[]d_dc= {-1,-1,1,1};
					for(int k=1;k<M;k++) {
						for(int idx=0;idx<4;idx++) {
							int new_x=x+d_dr[idx]*k;
							int new_y=y+d_dc[idx]*k;
							if(new_x>=0 && new_x<N && new_y>=0 && new_y<N) {
								sum2+=n_arr[new_x][new_y];
							}
						}
					}
					sum2+=n_arr[x][y];
					
					max[x][y]=Math.max(sum1,sum2);
					f_max=Math.max(max[x][y], f_max);
				}
			}
			System.out.println("#"+(t+1)+" "+f_max);			
		}
		
	}
}
