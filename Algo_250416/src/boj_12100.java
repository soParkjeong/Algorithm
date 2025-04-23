import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj_12100 {
	static int[][] map;
	static int N;
	static boolean[][]visited;//얘는 새로운 시작점으로 bfs 돌릴 때마다 초기화 
	static int[][]add_check;//합침여부(0,1) 체크용 2차원 배열 
	static Queue<Node>q;
	static int[]dx;
	static int[]dy;
	static class Node{
		int x,y;
		int depth;
		boolean add;
		Node(int x,int y,int depth,boolean add){
			this.x=x;
			this.y=y;
			this.depth=depth;
			this.add=add;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		map=new int[N][N];
		add_check=new int[N][N];
		
		dx=new int[] {-1,1,0,0};
		dy=new int[] {0,0,-1,1};
		
		for(int i=0;i<N;i++) {
			String[]str=br.readLine().trim().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(str[j]);
			}
		}//맵 완성 
		 
			q=new LinkedList<>();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					visited=new boolean[N][N];
					if(map[i][j]>=2) {//2보다 크거나 같은 칸은 숫자가 있는 칸!->모두 출발지로 큐에 넣기 
						visited[i][j]=true;
						q.add(new Node(i,j,0,false));
						bfs(map,add_check);
					}
				}
			}
			
			int max=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					max=Math.max(max, map[i][j]);
				}
			}
			
			System.out.println(max);
		}
	
	static void bfs(int[][]map,int[][]add_check) {
		int count=1;
		boolean check=false;
		ArrayList<Integer>list=new ArrayList<>();
		
		while(!q.isEmpty()) {
			Node node=q.poll();
			int curr_x=node.x;
			int curr_y=node.x;
			int curr_num=map[node.x][node.y];
			int curr_depth=node.depth;
			boolean curr_add=node.add;
			
			if(curr_add) {//같은 게 찾아지면 
				check=true;
			}
			
			if(count==5) {
				return;
			}
			
			int power=1;
			for(int k=0;k<4;k++) {//상하좌우 
				while(true) {
					int nx=curr_x+dx[k]*power;
					int ny=curr_y+dy[k]*power;
					if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]) {
						if(map[nx][ny]==curr_num&&!curr_add&&map[nx][ny]!=0) {//같은 걸 찾아서 합쳐지면 
							visited[nx][ny]=true;
							q.add(new Node(nx,ny,curr_depth+1,true));
							power++;
							map[curr_x][curr_y]=0;//원래 자리는 0이 되고,
							map[nx][ny]=curr_num*2;//새로 갈 방향의 그 새로운 자리가 2배가 됨 	
						}else {
							visited[nx][ny]=true;
							q.add(new Node(nx,ny,curr_depth+1,false));
							break;
						}
					}else {
						check=true;//그 방향으로가 끝이면 check를 true로 바꾸고 break(1번 이동으로 침)
//						for(int i=0;i<N;i++) {
//							System.out.println(Arrays.toString(map[i]));
//						}
//						System.out.println();
						break;//그 방향으로가 끝이면 break;
					}
				}
				if(check) {
					count++;//이동 횟수 세어주기 
				}
			}
		}
	}
}
