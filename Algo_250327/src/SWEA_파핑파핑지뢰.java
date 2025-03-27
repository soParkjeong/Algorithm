import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_파핑파핑지뢰 {
	static char[][]pop;
	static int[] dx;
	static int[] dy;
	static boolean[][] visited;
	static int N;
	static Queue<Node>queue;
	static int cnt;
	
	static class Node{
		int x,y;
		public Node(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	
//일단 처음으로 발견되는 .지점부터 시작-> 그 지점으로부터 인접한 8방향에 대해 인접 8방향의 지뢰 개수 기재-> 
//다음으로 이동할 8방향 중 0인 곳이 있으면 그 곳으로부터 또 8방향 지뢰 개수세기-> 없으면 다음 . 찾기 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			N=Integer.parseInt(br.readLine());
			
			dx=new int[] {-1,1,0,0,-1,1,-1,1};
			dy=new int[] {0,0,-1,1,-1,1,1,-1};
			
			queue=new LinkedList<>();
			
			cnt=0;
			
			visited=new boolean[N][N];
			
			pop=new char[N][N];
			
			for(int i=0;i<N;i++) {
				char[]ch=br.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					pop[i][j]=ch[j];
				}
			}
			
			//0인 곳 주변도 탐색하고, .인 곳도 탐색해야 하네
			//독립적으로 탐색하자 
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(pop[i][j]=='.' && !visited[i][j] && countpop(i,j)==0) {//.이면서 방문 안했으면서 8방 탐색하며 누적 지뢰 개수가 0인 곳 
						bfs(i,j);
						cnt++;//클릭 횟수 증가 
					}
				}
			}//지뢰 배열 완성
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(pop[i][j]=='.' && !visited[i][j]) {//.이면서 방문 안한 곳 
						visited[i][j]=true;
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}
	
	static void bfs(int x,int y) {
		queue.add(new Node(x,y));
		visited[x][y]=true;
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			
			for(int k=0;k<8;k++) {
				int nx=node.x+dx[k];
				int ny=node.y+dy[k];
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && pop[nx][ny]=='.') {
					//방문한 곳은 숫자로 바뀔테니까 굳이 visited 처리 안해줘도 되겠지...? 아니다 0은 다시 가야하네-> 갔던 0 다시 안가려면 방문처리해줘야 할 듯,,, 
					visited[nx][ny]=true;
					if(countpop(nx,ny)==0) {
						queue.add(new Node(nx,ny));
					}
				}
			}
		}
	}
	
	static int countpop(int x,int y) {//인접 지뢰 개수 세는 메서드 
		int poppop=0;
		for(int k=0;k<8;k++) {
			int nx=x+dx[k];
			int ny=y+dy[k];
			if(nx>=0 && nx<N && ny>=0 && ny<N && pop[nx][ny]=='*') {//벽 내에서 지뢰 개수 세기 
				poppop++;
			}
		}
		return poppop;
	}
}
