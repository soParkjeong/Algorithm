import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_14442 {
	static int[][]arr;
	static boolean[][][]visited;
	static Queue<Node>q;
	static int[]dx;
	static int[]dy;
	static int N;
	static int M;
	static int K;
	
	static class Node{
		int x,y,move,cnt;
		Node(int x,int y,int move,int cnt){
			this.x=x;
			this.y=y;
			this.move=move;
			this.cnt=cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		//N, M, K
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[]NMK=br.readLine().trim().split(" ");
		N=Integer.parseInt(NMK[0]);
		M=Integer.parseInt(NMK[1]);
		K=Integer.parseInt(NMK[2]);
		
		arr=new int[N][M];
		visited=new boolean[N][M][K+1];
		
		q= new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			char[]ch=br.readLine().trim().toCharArray();
			for(int j=0;j<M;j++) {
				arr[i][j]=ch[j]-'0';
			}
		}//배열 완성
		
		dx=new int[] {-1,1,0,0};
		dy=new int[] {0,0,-1,1};
		
		q.add(new Node(0,0,1,0));//시작과 동시에 한번 움직임 
		visited[0][0][0]=true;
		System.out.println(bfs(0,0));
	}
	
	static int bfs(int sx,int sy) {
		while(!q.isEmpty()) {
			Node node=q.poll();
			int cx=node.x;
			int cy=node.y;
			int c_move=node.move;
			int c_cnt=node.cnt;
			
			if(cx==N-1 && cy==M-1) {
				return c_move;
			}
			
			for(int k=0;k<4;k++) {
				int nx=cx+dx[k];
				int ny=cy+dy[k];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if (arr[nx][ny] == 0) {
						if(!visited[nx][ny][c_cnt]) {
							visited[nx][ny][c_cnt]=true;
							q.add(new Node(nx,ny,c_move+1,c_cnt));
						}
					}else {
						if(c_cnt<K && !visited[nx][ny][c_cnt+1]) {
							visited[nx][ny][c_cnt+1]=true;
							q.add(new Node(nx,ny,c_move+1,c_cnt+1));
						}
					}
				}
			}
		}
		return -1;
	}
}
