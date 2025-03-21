import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bj_미로탐색 {
	static boolean[][]visited;
	static int[][]miro;
	static int[] dx;
	static int[] dy;
	static int[] current;
	static int current_x;
	static int current_y;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] NM=br.readLine().split(" ");
		int N=Integer.parseInt(NM[0])-1;//인덱스니까 -1
		int M=Integer.parseInt(NM[1])-1;//인덱스니까 -1
		
		miro=new int[N+1][M+1];
		visited=new boolean[N+1][M+1];
		current=new int[3];
		dx= new int[]{-1,1,0,0};
		dy= new int[]{0,0,-1,1};
		
		for(int i=0;i<N+1;i++) {
			char[]arr=br.readLine().toCharArray();
			for(int j=0;j<M+1;j++) {
				miro[i][j]=arr[j]-'0';
			}
		}//배열 완성
		//System.out.println(Arrays.deepToString(miro));
		
		int start_x=0;
		int start_y=0;
		int cnt=1;
		
		System.out.println(bfs(start_x,start_y,cnt,N,M));
	}
	
	static int bfs(int start_x,int start_y,int cnt,int N,int M) {
		Queue<int[]>queue=new LinkedList<>();
		//항상 0,0에서 시작
		visited[start_x][start_y]=true;
		queue.add(new int[] {start_x,start_y,cnt});//제일 처음 시작점 큐에 넣어주기 
		
		while(true) {
			current=queue.poll();
			//System.out.println(Arrays.toString(current));
			//System.out.println(current[0]+","+current[1]+","+current[2]);
			if(current[0]==N && current[1]==M) {
				return current[2];
			}
			
			for(int k=0;k<4;k++) {
				int n_x=current[0]+dx[k];
				int n_y=current[1]+dy[k];
				if(n_x<0||n_y<0||n_x>=N+1||n_y>=M+1||visited[n_x][n_y]||miro[n_x][n_y]==0) {
					continue;
				}
				int n_cnt=current[2]+1;//1번 증가 
				visited[n_x][n_y]=true;//방문처리 
//				for(int i=0;i<N;i++) {
//					System.out.println(Arrays.toString(visited[i]));
//				}
				queue.add(new int[] {n_x,n_y,n_cnt});//현재 좌표 큐에 추가 
			}
		}
	}
}