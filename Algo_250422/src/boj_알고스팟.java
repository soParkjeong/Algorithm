import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_알고스팟 {
	static int[][]arr;
	static boolean[][][]visited;
	static int[]dx;
	static int[]dy;
	static int N;
	static int M;
	static int K;
	static Queue<Node>q;
	static class Node{
		int x,y,cnt;
		Node(int x,int y,int cnt){
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[]NM=br.readLine().trim().split(" ");
		N=Integer.parseInt(NM[0]);
		M=Integer.parseInt(NM[1]);
		
		arr=new int[N][M];
		K=N*M;
		visited=new boolean[N][M][K+1];
		dx=new int[] {-1,1,0,0};
		dy=new int[] {0,0,-1,1};
		
		q=new LinkedList<>();
		for(int i=0;i<N;i++) {
			char[]ch=br.readLine().trim().toCharArray();
			for(int j=0;j<M;j++) {
				arr[i][j]=ch[j]-'0';
			}
		}//배열 완성 
		
		if (arr[0][0] == 1) {
			q.add(new Node(0, 0, 1));
			visited[0][0][1] = true;
		} else {
			q.add(new Node(0, 0, 0));
			visited[0][0][0] = true;
		}
		int result=bfs();
		
		System.out.println(result);
	}
	
	static int bfs() {
		int min=Integer.MAX_VALUE;
		while(!q.isEmpty()) { 
			Node node=q.poll();
			int cx=node.x;
			int cy=node.y;
			int c_cnt=node.cnt;
			
			if(cx==N-1 && cy==M-1) {
				min=Math.min(min, c_cnt);
			}
			
			for(int k=0;k<4;k++) {
				int nx=cx+dx[k];
				int ny=cy+dy[k];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(arr[nx][ny]==1 && c_cnt + 1 <= K && !visited[nx][ny][c_cnt+1]) {
						visited[nx][ny][c_cnt+1]=true;
						q.add(new Node(nx,ny,c_cnt+1));
					}else if(arr[nx][ny]==0 && !visited[nx][ny][c_cnt]) {
						visited[nx][ny][c_cnt]=true;
						q.add(new Node(nx,ny,c_cnt));
					}
				}
			}
		}
		return min;
	}
}
