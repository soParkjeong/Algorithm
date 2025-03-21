package 과목평가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class looknight {
	static int N;
	static  int M;
	static int[][]arr;
	static int K;
	static int[] lx;
	static int[] ly;
	static int[] nx;
	static int[] ny;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		
		for(int tc=1;tc<=T;tc++) {
			String[]NMK=br.readLine().trim().split(" ");
			N=Integer.parseInt(NMK[0]);
			M=Integer.parseInt(NMK[1]);
			K=Integer.parseInt(NMK[2]);//기저조건에 쓰일 듯?
			
			arr=new int[N][M];
			int l_x=0;
			int l_y=0;
			
			int n_x=0;
			int n_y=0;
			for(int i=0;i<N;i++) {
				String[]str=br.readLine().trim().split(" ");
				for(int j=0;j<M;j++) {
					arr[i][j]=Integer.parseInt(str[j]);
					if(arr[i][j]==1) {
						l_x=i;
						l_y=j;
					}
					if(arr[i][j]==2) {
						n_x=i;
						n_y=j;
					}
				}
			}//배열 완성
			
			lx= new int[]{-1,1,0,0};
			ly= new int[] {0,0,-1,1};
			
			nx=new int[] {-2,-2,-1,-1,1,1,2,2};
			ny=new int[] {-1,1,-2,2,-2,2,-1,1};
			
			cnt=night(l_x,l_y,n_x,n_y);
			System.out.println(cnt);
		}
	}
	
	static class Node{
		int lx,ly,nx,ny,move;
		Node(int lx,int ly,int nx,int ny,int move){
			this.lx=lx;//x 좌표 
			this.ly=ly;//y 좌표 
			this.nx=nx;
			this.ny=ny;
			this.move=move;//움직인 횟수 
		}
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Node node = (Node) o;
			return lx == node.lx && ly == node.ly && nx == node.nx && ny == node.ny;
		}

		@Override
		public int hashCode() {
			return Objects.hash(lx, ly, nx, ny);
		}
	}
	
	static int night(int l_x,int l_y,int n_x,int n_y) {
		boolean[][][][]visited=new boolean[N][M][N][M];//내가 저장하고 싶은 정보의 개수-1 차원으로 다차원 배열 정의 가능(배열은 차원의 크기(n), 배열의 값(1개)으로 정보(총 n+1개의 정보)를 나타낼 수 있기 때문) 
		Queue<Node>queue=new LinkedList<>();
		
		queue.add(new Node(l_x,l_y,n_x,n_y,0));
		visited[l_x][l_y][n_x][n_y]=true;
		
		Set<Node> validCases=new HashSet<>();
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			
			if(node.move==K) {
				validCases.add(node);
				continue;
			}
			
			for(int k=0;k<4;k++) {
				int count=1;
				while(true) {
					int new_lx=node.lx+lx[k]*count;
					int new_ly=node.ly+ly[k]*count;
					
					if(new_lx<N && new_lx>=0 && new_ly<M && new_ly>=0 && !visited[new_lx][new_ly][node.nx][node.ny]) {
						visited[new_lx][new_ly][node.nx][node.ny]=true;
						queue.add(new Node(new_lx,new_ly,node.nx,node.ny,node.move+1));
						
						count++;
					}else {
						break;
					}
				}
			}
			
			for(int k=0;k<8;k++) {
				int new_nx=node.nx+nx[k];
				int new_ny=node.ny+ny[k];
				
				if(new_nx<N && new_nx>=0 && new_ny>=0 && new_ny<M && !visited[node.lx][node.ly][new_nx][new_ny]) {
					visited[node.lx][node.ly][new_nx][new_ny]=true;
					queue.add(new Node(node.lx,node.ly,new_nx,new_ny,node.move+1));
				}else {
					break;
				}
			}
		}
		return validCases.size();
	}
	
}
