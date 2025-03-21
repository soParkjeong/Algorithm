import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_23795 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
			int[][]result=new int[N][N];
			for(int i=0;i<N;i++) {
				String[]arr=br.readLine().trim().split(" ");
				for(int j=0;j<N;j++) {
					result[i][j]=Integer.parseInt(arr[j]);
				}
			}//배열 완성 
			int cnt0=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(result[i][j]==0) {
						cnt0++;
					}
				}
			}
			//System.out.println(cnt0);
			
			int x=0;
			int y=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(result[i][j]==2) {
						x=i;
						y=j;
					}
				}
			}
			
			int[] dx={-1,1,0,0};
			int[] dy={0,0,-1,1};
			int cnt=0;
			for(int i=0;i<4;i++){
					int n_x=x;
					int n_y=y;//현 위치 저장 
				while(true){
					n_x+=dx[i];//i번째 방향으로 쭉 가기
					n_y+=dy[i];
					if(n_x<0||n_x>=N||n_y<0||n_y>=N||result[n_x][n_y]==1) break;
					cnt++;//광선 지나간 자리 세어주기 
					}
				}
					
			//System.out.println(cnt);
			System.out.println("#"+(t+1)+" "+(cnt0-cnt));				
		}
	}
}
