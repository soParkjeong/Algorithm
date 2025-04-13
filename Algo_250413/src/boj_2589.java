import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2589 {
	static int N;
	static int M;
	static char[][]map;
	static boolean[][] visited;
	static Queue<Node>q;
	static int[]dx;
	static int[]dy;
	static class Node{
		int x,y,depth;
		Node(int x,int y,int depth){
			this.x=x;
			this.y=y;
			this.depth=depth;
		}
	}
	public static void main(String[] args) throws IOException {
		//육지:L
		//바다:W
		//상하좌우 육지로만 이동//보물-보물 간에 최단거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있음
		//육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳 지나가면 안됨 
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		//육지에서 다른 육지칸으로 이동할 때 가장 멀리 있는 곳만 저장->가장 멀리 있는 그게 보물이 묻힌 곳이자 정답(최단거리로 찾되, 젤 멀리 있는 곳을 찾은거니까)
		String[]NM=br.readLine().trim().split(" ");
		
		N=Integer.parseInt(NM[0]);//세로
		M=Integer.parseInt(NM[1]);//가로
		map=new char[N][M];
		for(int i=0;i<N;i++) {
			char[]str=br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j]=str[j];
			}
		}//맵 생성 
		
		dx=new int[] {-1,1,0,0};
		dy=new int[] {0,0,-1,1};
		
		int final_max=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visited=new boolean[N][M];
				if(map[i][j]=='L') {
					q=new LinkedList<>();
					q.add(new Node(i,j,0));
					visited[i][j]=true;
					int result=bfs();
					final_max=Math.max(final_max,result);
				}
			}
		}
		System.out.println(final_max);
	}
	
	static int bfs() {
		int max=0;
		while(!q.isEmpty()) {
			Node node=q.poll();
			int cx=node.x;
			int cy=node.y;
			int c_depth=node.depth;
			
			if(map[cx][cy]=='L') {
				max=Math.max(max, c_depth);
			}
			
			for(int k=0;k<4;k++) {
				int nx=cx+dx[k];
				int ny=cy+dy[k];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&!visited[nx][ny]&&map[nx][ny]=='L') {
					q.add(new Node(nx,ny,c_depth+1));
					visited[nx][ny]=true;
				}
			}
		}
		return max;
	}
}
