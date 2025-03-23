package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_7576 {
	static int N;
	static int M;
	static int[] dx;
	static int[] dy;
	static int[][] tomato;
	static Queue<Node>queue;
	
	static class Node{
		int x,y,cnt;
		Node(int x,int y,int cnt){
			this.x=x;
			this.y=y;
			this.cnt=cnt;//날짜 
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[]NM=br.readLine().trim().split(" ");
		M=Integer.parseInt(NM[0]);
		N=Integer.parseInt(NM[1]);
		
		dx= new int[]{-1,1,0,0};
		dy= new int[] {0,0,-1,1};
		
		boolean check=true;//이미 저장될 때부터 토마토가 모두 익은 상태인지 체크 
		
		queue=new LinkedList<>();
		
		tomato=new int[N][M];
		for(int i=0;i<N;i++) {
			String[]str=br.readLine().trim().split(" ");
			for(int j=0;j<M;j++) {
				tomato[i][j]=Integer.parseInt(str[j]);
				if(tomato[i][j]==1) {//익은 토마토 있는 곳 시작점으로 큐에 넣기 
					queue.add(new Node(i,j,0));
				}
				if(tomato[i][j]==0) {
					check=false;
				}
			}
		}//배열 완성
		
		int result=bfs();
		
		if(check) {
			System.out.println(0);
		}else {
			boolean f_check=true;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(tomato[i][j]==0) {//아직 안 익은 사과가 있다면 
						f_check=false;
						break;
					}
				}
			}
			if(f_check) {//사과가 다 익었다면 
				System.out.println(result);
			}else {
				System.out.println(-1);
			}
		}
	}
	
	
	static int bfs() {
		int lastDay=0;
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();//현재 위치 파악
			lastDay=Math.max(lastDay,node.cnt);//가장 마지막으로 익는 날짜 구하기 
		
			for(int k=0;k<4;k++) {
				int new_x=node.x+dx[k];
				int new_y=node.y+dy[k];
				
				if(new_x>=0 && new_x<N && new_y>=0 && new_y<M) {//상자 안이고
					if(tomato[new_x][new_y]==0) {//익지 않은 토마토가 있으면 
						tomato[new_x][new_y]=1;//익은 토마토로 바꾸기 
						queue.add(new Node(new_x,new_y,node.cnt+1));//날짜 추가하고 큐에 현재 위치 추가 
					}
				}
			}
		}
		return lastDay;
	}
}
