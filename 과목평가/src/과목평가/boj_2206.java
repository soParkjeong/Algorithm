package 과목평가;

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
					if(!visited[new_x][new_y][1] && arr[new_x][new_y]==1 && node.cnt==0) {//아직 방문하지 않았고,아직 벽을 부순 적이 없고/새로 이동한 칸의 위치가 이동할 수 없는 곳이고/벽을 깬 횟수가 0일 때 
						visited[new_x][new_y][1]=true;
						queue.add(new Node(new_x,new_y,node.move+1,1));
					}else if(arr[new_x][new_y]==0 && !visited[new_x][new_y][node.cnt]) {
						visited[new_x][new_y][node.cnt]=true;
						queue.add(new Node(new_x,new_y,node.move+1,node.cnt));
					}
				}
			}
		}
		return -1;
	}
}
