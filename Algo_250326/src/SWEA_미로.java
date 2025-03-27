import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_미로 {
	static int[]dx;
	static int[]dy;
	static boolean[][]visited;
	static int result;
	static int[][] miro;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N=Integer.parseInt(br.readLine());
			miro=new int[N][N];
			
			dx= new int[]{-1,1,0,0};
			dy= new int[]{0,0,-1,1};
			
			int s_x=0;
			int s_y=0;
			
			visited=new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				char[]ch=br.readLine().trim().toCharArray();
				for(int j=0;j<N;j++) {
					miro[i][j]=ch[j]-'0';
					if(miro[i][j]==2) {
						s_x=i;
						s_y=j;
					}
				}
			}//미로 완성 
			
			result=0;
			dfs(s_x,s_y);
			
			System.out.println("#"+tc+" "+result);
		}
	}
	static void dfs(int x,int y) {
		if(miro[x][y]==3) {
			result=1;
			return;
		}
		
		visited[x][y]=true;
		
		for(int k=0;k<4;k++) {
			int n_x=x+dx[k];
			int n_y=y+dy[k];
			if(n_x >= 0 && n_x < N && n_y >= 0 && n_y < N) {
				if(miro[n_x][n_y]!=1 && !visited[n_x][n_y]) {
					dfs(n_x,n_y);
				}
			}
		}
	}
}
