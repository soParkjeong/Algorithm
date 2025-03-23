package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class boj_2636 {
	static int[] dx;
	static int[] dy;
	static int N;
	static int M;
	static int[][]cheese;
	static Queue<NodeAir>airQueue;
	static Queue<Node>cheeseQueue;
	
	static class Node{
		int x,y,cnt;
		Node(int x,int y,int cnt){
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	
	static class NodeAir{
		int x,y;
		NodeAir(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[]NM=br.readLine().trim().split(" ");
		N=Integer.parseInt(NM[0]);
		M=Integer.parseInt(NM[1]);

		dx=new int[] {-1,1,0,0};
		dy=new int[] {0,0,-1,1};
		
		cheese=new int[N][M];
		
		cheeseQueue=new LinkedList<>();
		airQueue=new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			String[]str=br.readLine().trim().split(" ");
			for(int j=0;j<M;j++) {
				cheese[i][j]=Integer.parseInt(str[j]);
			}
		}//배열 완성 
		
		int time=0; 
		int lastCheese=0;
		while(true) {//치즈 다 녹을 때까지 외부공기 찾기와 치즈 녹이기 무한 반복 
			airbfs(0,0);
			int cheeseCount=cheesebfs();//치즈 녹이기
			if(cheeseCount==0) {
				break;
			}
			lastCheese=cheeseCount;//마지막 루프가 돌기 직전(다 녹기 한 시간 전) 남은 치즈 개수 
			time++;//다 녹는데 걸리는 시간 
		}
		System.out.println(time);
		System.out.println(lastCheese);
	}
				
	static void airbfs(int x,int y) {

		airQueue.add(new NodeAir(x,y));
		cheese[x][y]=2;//외부 공기 처리 
		
		while(!airQueue.isEmpty()) {
			NodeAir node=airQueue.poll();
			
			for(int k=0;k<4;k++) {
				int new_x=node.x+dx[k];
				int new_y=node.y+dy[k];
				
				if(new_x>=0 && new_x<N && new_y>=0 && new_y<M) {
					if(cheese[new_x][new_y]==0) {
						cheese[new_x][new_y]=2;
						airQueue.add(new NodeAir(new_x,new_y));
					}
				}
			}
		}
	
	}
	
	static int cheesebfs() {
		int cheeseCount=0;
		
		 for (int i = 0; i < N; i++) {
		        for (int j = 0; j < M; j++) {
		            if (cheese[i][j] == 1) { // 치즈가 있는 곳
		                for (int k = 0; k < 4; k++) {//사방 탐색(치즈가 있는 자리에서 사방탐색-외부공기와 맞닿은 치즈인지 체크)
		                    int nx = i + dx[k];
		                    int ny = j + dy[k];
		                    
		                    if(nx>=0 && nx<N && ny>=0 && ny<M) {
		                    	if(cheese[nx][ny]==2) {//외부공기와 맞닿아있는 치즈면 
		                    		cheeseQueue.add(new Node(i,j,0));
		                    		cheeseCount++;//치즈 개수 세어주고 
		                    		break;
		                    	}
		                    }
		                }
		           }
		      }
		 }
		 
     	while (!cheeseQueue.isEmpty()) {
            Node node = cheeseQueue.poll();
            cheese[node.x][node.y] = 2;
        }
		 
		 return cheeseCount;//남아있던 치즈 개수 반환 
	}
}
		                    
