import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_7562 {
	static int[][] arr;
	static int cnt;
	static int[] dx= {1,2,-1,-2,-1,-2,1,2};
	static int[] dy= {2,1,2,1,-2,-1,-2,-1};
	
	 static class Node {//큐에 세트로 저장하기 위해 사용 
	        int x, y, move;
	        Node(int x, int y, int move) {
	            this.x = x;
	            this.y = y;
	            this.move = move;
	        }
	    }
	 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=0;tc<T;tc++) {

			int I=sc.nextInt();

			int current_x=sc.nextInt();
			int current_y=sc.nextInt();
				
			int goal_x=sc.nextInt();
			int goal_y=sc.nextInt();

			cnt=bfs(I,current_x,current_y,goal_x,goal_y);		
			System.out.println(cnt);
		}
	}
	
	static int bfs(int I,int x,int y,int gx,int gy) {
		boolean[][] visited=new boolean[I][I];
		Queue<Node>queue=new LinkedList<>();
	
		queue.add(new Node(x,y,0));//시작위치 
		visited[x][y]=true;//시작점 방문 처리 
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			
			if(node.x==gx && node.y==gy) {
				return node.move;
			}
			
			//8방향으로 이동
			for(int k=0;k<8;k++) {
				int new_x=node.x+dx[k];
				int new_y=node.y+dy[k];
				
				if(new_x<I && new_x>=0 && new_y<I && new_y>=0 && !visited[new_x][new_y]) {
					visited[new_x][new_y]=true;
					queue.add(new Node(new_x,new_y,node.move+1));
				}
			}
		}
		return -1;
	}
}
