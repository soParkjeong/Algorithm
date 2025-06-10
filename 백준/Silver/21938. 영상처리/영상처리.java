import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[]dx= {-1,1,0,0};;
	static int[]dy= {0,0,-1,1};;
	static boolean[][]visited;
	static int N;
	static int M;
	static int T;
	static int[][]gray;
	static int count;
	public static void main(String[] args) throws IOException {
		//만약, 세로 길이가 N이고 가로 길이가 M인 화면은 N X M개의 픽셀
		//R,G,B 3가지 색상
		//모든 픽셀 3가지 색상을 평균-> T보다 크같으면 픽셀의 값은 255로, 작으면 0으로 바꿔야 함
		//값이 255인 픽셀은 물체로 인식
		//값이 255인 픽셀들이 상하좌우로 인접했다면 같은 물체로 인식
		//N,M
		//T
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		gray=new int[N][M];
		
		count=0;//물체 개수 
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int avg=0;
				for(int k=0;k<3;k++) {
					avg+=Integer.parseInt(st.nextToken());
				}
				gray[i][j]=avg/3;
			}
		}
		
		T=Integer.parseInt(br.readLine());
		visited=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if (gray[i][j] >= T) {
					gray[i][j] = 255;
				} else {
					gray[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (gray[i][j] == 255 && !visited[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		
		System.out.println(count);

	}
	
	public static void dfs(int x,int y) {
		visited[x][y]=true;
		
		for(int k=0;k<4;k++) {
			int nx=x+dx[k];
			int ny=y+dy[k];
			
			if(nx>=0&&ny>=0&&nx<N&&ny<M) {
				if(gray[nx][ny]>=T && !visited[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
	}
}
