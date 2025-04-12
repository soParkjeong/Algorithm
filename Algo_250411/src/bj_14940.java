import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_14940 {
	static int[][]arr;
	static int n;
	static int m;
	static int[][]result;
	static boolean[][]visited;
	static int[]dx;
	static int[]dy;
	static class Node{
		int x;
		int y;
		int depth;
		Node(int x,int y,int depth){
			this.x=x;
			this.y=y;
			this.depth=depth;
		}
	}
	static Queue<Node>q;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[]nm=br.readLine().trim().split(" ");
		
		n=Integer.parseInt(nm[0]);
		m=Integer.parseInt(nm[1]);
		
		arr=new int[n][m];
		dx=new int[] {-1,1,0,0};
		dy=new int[] {0,0,-1,1};
		
		int sx=0;
		int sy=0;
		for(int i=0;i<n;i++) {
			String[]str=br.readLine().trim().split(" ");
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(str[j]);
				if(arr[i][j]==2) {
					sx=i;
					sy=j;
				}
			}
		}//배열 완성
		
		visited=new boolean[n][m];//칸 마다 vistied 배열 초기화  
		result=new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					result[i][j]=0;
				}else {
					result[i][j]=-1;//처음에 -1로 초기화하면 bfs로 도달 가능한 부분은 갱신될테고 도달하지 못하는 부분은 -1이겠지 
				}
			}
		}
		
		q=new LinkedList<>();//칸 마다 큐 초기화 
		q.add(new Node(sx,sy,0));
		result[sx][sy] = 0;
		visited[sx][sy]=true;
		bfs();
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(result[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Node node=q.poll();
			int curr_x=node.x;
			int curr_y=node.y;
			int curr_depth=node.depth;
			
			result[curr_x][curr_y]=curr_depth;
			
			for(int k=0;k<4;k++) {
				int n_x=curr_x+dx[k];
				int n_y=curr_y+dy[k];
				if(n_x>=0&&n_x<n&&n_y>=0&&n_y<m&&!visited[n_x][n_y]&&arr[n_x][n_y]==1) {
					visited[n_x][n_y]=true;
					q.add(new Node(n_x,n_y,curr_depth+1));
				}
			}
		}
	}
}
