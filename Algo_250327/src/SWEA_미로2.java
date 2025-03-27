import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_미로2 {
	static boolean[][]visited;
	static int[][]miro;
	static int[]dx;
	static int[]dy;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			int tc=Integer.parseInt(br.readLine().trim());
			
			miro=new int[100][100];
			
			visited=new boolean[100][100];
			
			dx=new int[] {-1,1,0,0};
			dy=new int[] {0,0,-1,1};
			
			int sx=0;
			int sy=0;
			
			for(int i=0;i<100;i++) {
				char[]ch=br.readLine().trim().toCharArray();
				for(int j=0;j<100;j++) {
					miro[i][j]=ch[j]-'0';
					if(miro[i][j]==2) {
						sx=i;
						sy=j;
					}
				}
			}//배열 완성 
			
			result=0;
			dfs(sx,sy);
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static void dfs(int x,int y) {
		if(miro[x][y]==3) {
			result=1;
			return;
		}
		
		for(int k=0;k<4;k++) {
			int nx=x+dx[k];
			int ny=y+dy[k];
			if(nx>=0 && nx<100 && ny>=0 && ny<100&&!visited[nx][ny]) {
				if(miro[nx][ny]!=1) {
					visited[x][y]=true;
					dfs(nx,ny);
				}
			}
		}
	}
}
