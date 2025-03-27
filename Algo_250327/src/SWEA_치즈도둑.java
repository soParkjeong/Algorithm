import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_치즈도둑 {
	static int N;
	static int[][]cheese;
	static int[] dx;
	static int[] dy;
	static boolean[][]visitedCheese;
	static boolean[][]visited;
	static int maxCount;
	static Queue<Node>queue;
	
	static class Node{
		int x,y,day;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			N=Integer.parseInt(br.readLine().trim());
			
			cheese=new int[N][N];
			
			dx=new int[] {-1,1,0,0};
			dy=new int[] {0,0,-1,1};
			
			for(int i=0;i<N;i++) {
				String[]str=br.readLine().trim().split(" ");
				for(int j=0;j<N;j++) {
					cheese[i][j]=Integer.parseInt(str[j]);
				}
			}
			
			visitedCheese=new boolean[N][N];
			maxCount=1;
			
			for(int day=1;day<=100;day++) {
				visited=new boolean[N][N];
				
				//일단 해당 날짜와 동일한 치즈 칸 방문 처리해주는 메서드 돌리기 
				eatCheese(day);
				
				int cnt=0;
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(!visited[i][j] && cheese[i][j]>day) {//매번 visited 배열을 갱신해주기 때문에 현재 day보다 큰 부분만 녹여주는 뒷 조 필요 
							bfs(i,j);
							cnt++;
						}
					}
				}
				maxCount=Math.max(maxCount, cnt);
			}
			
			//뭔가 dfs 쓰되, 덩어리가 가장 많을 때니까 Math.max나 갱신하는 형태로 가면서 
			//하루 지날 때마다 치즈 개수 세서 최대 개수로 갱신 
			System.out.println("#"+tc+" "+maxCount);
			
		}
	}
	
	//하루동안 먹는 치즈 
	static void eatCheese(int day) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(cheese[i][j]==day) {
					visitedCheese[i][j]=true;//꺼낸 노드에 있는 현재 일수와 일치하는 자리의 치즈를 먹은 것 처리 
				}
			}
		}
	}

	//덩어리 탐색 BFS 
	static void bfs(int x,int y) {
		Queue<Node>queue=new LinkedList<>();//하루가 지날때 마다 새로운 큐 생성해서 치즈 덩어리 개수 세기 
		queue.add(new Node(x,y));
		visited[x][y]=true;
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			
			for(int k=0;k<4;k++) {
				int nx=node.x+dx[k];
				int ny=node.y+dy[k];
				
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny] && !visitedCheese[nx][ny]) {
					visited[nx][ny]=true;
					queue.add(new Node(nx,ny));
				}
			}
		}
	}		
}
