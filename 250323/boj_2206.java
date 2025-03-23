package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2206 {
	static int N;
	static int M;
	static int[][] arr;
	static int[] dx;
	static int[] dy;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[]NM=br.readLine().trim().split(" ");
		N=Integer.parseInt(NM[0]);
		M=Integer.parseInt(NM[1]);
		arr=new int[N][M];
		
		for(int i=0;i<N;i++) {
			char[]ch=br.readLine().trim().toCharArray();
			for(int j=0;j<M;j++) {
				arr[i][j]=ch[j]-'0';
			}
		}//배열 완성 
		dx=new int[] {-1,1,0,0};
		dy=new int[] {0,0,-1,1};
		
		System.out.println(bfs(0,0));//1,1 에서 시작한다지만, 인덱스로는 (0,0)에서 시작
	}
	
	static class Node{
		int x,y,move,cnt;
		Node(int x,int y, int move,int cnt){
			this.x=x;
			this.y=y;
			this.move=move;
			this.cnt=cnt;//벽 부순 횟수 
		}
	}
	
	static int bfs(int x,int y) {
		boolean[][][]visited=new boolean[N][M][2];//x,y 좌표 & 0이나 1의 여부 저장(“벽을 부순 이력”과 “방문 여부”를 동시에 관리하는 배열)
		//visited[x][y][0] → 벽을 부수지 않고 (x, y)에 도착한 경우 방문 여부
		//visited[x][y][1] → 벽을 한 번 부수고 (x, y)에 도착한 경우 방문 여부
		//같은 좌표 (x, y)라도 벽을 부수고 방문한 경우와 부수지 않고 방문한 경우를 따로 체크하는 구조
		//같은 좌표라도 현재 그 좌표를 방문할 때 벽을 부수고 왔는지, 벽을 부수지 않은 채로 왔는지에 따라 다음 경로가 바뀌기 때문에 저장하는 것임 
		
		Queue<Node>queue=new LinkedList<>();
		
		queue.add(new Node(x,y,1,0));//시작점(시작하는 칸도 셈-1, 이동할 수 있는 칸일테니까-0) 
		visited[x][y][0]=true;
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			
			if(node.x==N-1 && node.y==M-1) {
				return node.move;
			}
			
			for(int k=0;k<4;k++) {
				int new_x=node.x+dx[k];
				int new_y=node.y+dy[k];

				if(new_x>=0 && new_x<N && new_y>=0 && new_y<M) {//벽을 넘어가지 않는 선에서 
					//벽을 부수고 이동하는 경우 
					if(!visited[new_x][new_y][1] && arr[new_x][new_y]==1 && node.cnt==0) {//벽을 부순 상태로 방문한 적이 없고/이동할 위치가 벽(벽을 깨야 하는 곳)이고/벽을 깬 횟수가 0일 때 
						visited[new_x][new_y][1]=true;//벽 부수고(cnt 값을 1로 변경) 방문한 곳 방문 처리 
						queue.add(new Node(new_x,new_y,node.move+1,1));//움직인 횟수+1 해주고 큐에 add 하기 
					}
					//그냥 이동하는 경우(벽이 아님) 
					else if(arr[new_x][new_y]==0 && !visited[new_x][new_y][node.cnt]) {//이동할 위치가 벽이 아님(그냥 이동 가능)/해당 상태(벽을 부수거나, 부수지 않았거나)로 방문하지 않았고(굳이 0이나 1로 표시하지 않는 이유-벽을 깬 전적이 없으니까 두 가지 경우 모두 고려하며 방문 여부만 체크) 
						visited[new_x][new_y][node.cnt]=true;//벽을 부수지 않으니까 그 상태 그대로(node.cnt)(1로 바꿔주지 않음) 해당 상태로 방문한 곳 방문 처리 
						queue.add(new Node(new_x,new_y,node.move+1,node.cnt));//움직인 횟수+1 해주고 큐에 add 하기 
					}
				}
			}
		}
		return -1;
	}
}

