package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_7569 {
	static int[] dx;
	static int[] dy;
	static int[] dz;
	static int N;
	static int M;
	static int H;
	static int[][][] tomato;
	static Queue<Node>queue;
	
	static class Node{
		int x,y,z,cnt;
		Node(int x,int y,int z,int cnt){
			this.x=x;
			this.y=y;
			this.z=z;
			this.cnt=cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[]NMH=br.readLine().trim().split(" ");
		M=Integer.parseInt(NMH[0]);
		N=Integer.parseInt(NMH[1]);
		H=Integer.parseInt(NMH[2]);
		
		tomato=new int[N][M][H];
		
		boolean check=false;
		
		dx= new int[] {-1,1,0,0,0,0};
		dy=new int[] {0,0,-1,1,0,0};
		dz=new int[] {0,0,0,0,-1,1};
		
		queue=new LinkedList<>();
		int idx=0;
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				String[]str=br.readLine().trim().split(" ");
				for(int j=0;j<M;j++) {
					tomato[i][j][idx]=Integer.parseInt(str[j]);
					if(tomato[i][j][idx]==1) {
						queue.add(new Node(i,j,idx,0));//시작점 추가 
					}
					if(tomato[i][j][idx]==0) {//안 익은 토마토가 있다면 
						check=true;
					}
				}
			}
			idx++;
		}
		
		int result=bfs();
		idx=0;
		if(!check) {
			System.out.println(0);
		}else {
			boolean f_check=true;
			for(int k=0;k<H;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(tomato[i][j][idx]==0) {//탐색이 끝났는데도 아직 안익은게 있다면 
							f_check=false;
							break;
						}
					}
				}
				idx++;
			}
			if(f_check) {
				System.out.println(result);
			}else {
				System.out.println(-1);
			}
		}
	}
		
	static int bfs() {
		int lastday=0;
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			lastday=Math.max(lastday, node.cnt);
			
			for(int k=0;k<6;k++) {
				int new_x=node.x+dx[k];
				int new_y=node.y+dy[k];
				int new_z=node.z+dz[k];
				
				if(new_x>=0&&new_x<N&&new_y>=0&&new_y<M&&new_z>=0&&new_z<H) {
					if(tomato[new_x][new_y][new_z]==0) {
						tomato[new_x][new_y][new_z]=1;
						queue.add(new Node(new_x,new_y,new_z,node.cnt+1));
					}
				}
			}
		}
		return lastday;
	}
}
