import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_미로의거리 {
	static Queue<Node>queue;
	static int cnt;
	static int N;
	static boolean[][]visited;
	static int[] dx;
	static int[] dy;
	static int[][]miro;
	static int result;
	
	static class Node{
		int x,y,depth;
		
		Node(int x,int y,int depth) {
			this.x=x;
			this.y=y;
			this.depth=depth;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N=Integer.parseInt(br.readLine().trim());
			
			miro=new int[N][N];
			
			int sx=0;
			int sy=0;
			
			cnt=0;

			dx=new int[] {-1,1,0,0};
			dy=new int[] {0,0,-1,1};
			
			visited=new boolean[N][N];
			
			queue=new LinkedList<>();
			
			for(int i=0;i<N;i++) {
				char[]str=br.readLine().trim().toCharArray();
				for(int j=0;j<N;j++) {
					miro[i][j]=str[j]-'0';
					if(miro[i][j]==2) {
						sx=i;
						sy=j;
					}
				}
			}//배열 크기
			
			queue.add(new Node(sx,sy,0));
			visited[sx][sy]=true;
			
			result=bfs();
			System.out.println("#"+tc+" "+result);//도착지 제외 
		}
	}
	
	static int bfs() {
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			
			if(miro[node.x][node.y]==3) {
				return node.depth-1;
				
			}
		
			for(int k=0;k<4;k++) {
				int nx=node.x+dx[k];
				int ny=node.y+dy[k];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
					if(miro[nx][ny]!=1) {
						visited[nx][ny]=true;
						queue.add(new Node(nx,ny,node.depth+1));
					}
				}
			}
		}
		return 0;
	}
}
