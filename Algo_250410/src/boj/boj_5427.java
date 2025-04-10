package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_5427 {
	static char[][]bd;
	static boolean[][]visited;
	static int W;
	static int h;
	static class Node{
		int x;
		int y;
		int time;
		boolean fire;
		Node(int x,int y,int time,boolean fire){
			this.x=x;
			this.y=y;
			this.time=time;
			this.fire=fire;
		}
	}
	static Queue<Node> q;
	static int[]dx;
	static int[]dy;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//.: 빈 공간
		//#: 벽
		//@: 상근이의 시작 위치
		//*: 불
		//시작 위치 하나
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			String[]Wh=br.readLine().split(" ");
			W=Integer.parseInt(Wh[0]);
			h=Integer.parseInt(Wh[1]);
			
			int sx=0;
			int sy=0;
			int fx=0;
			int fy=0;
			
			bd=new char[h][W];
			visited=new boolean[h][W];
			
			dx= new int[]{-1,1,0,0};
			dy= new int[]{0,0,-1,1};
			
			q=new LinkedList<>();
			for(int i=0;i<h;i++) {
				char[]ch=br.readLine().trim().toCharArray();
				for(int j=0;j<W;j++) {
					bd[i][j]=ch[j];
					if(bd[i][j]=='*') {
						fx=i;
						fy=j;
						q.add(new Node(fx,fy,1,true));//불부터 쫙 큐에 넣기 
					}
					if(bd[i][j]=='@') {
						sx=i;
						sy=j;
					}
				}
			}//빌딩 완성 
			
			q.add(new Node(sx,sy,1,false));
			visited[sx][sy]=true;
			int result=bfs();
			
			if(result==0) {
				System.out.println("IMPOSSIBLE");
			}else {
				System.out.println(result);
			}
		}
	}
	
	static int bfs() {
		while(!q.isEmpty()) {
			Node node=q.poll();
			int curr_x=node.x;
			int curr_y=node.y;
			int curr_time=node.time;
			boolean fire_check=node.fire;
			
			if((curr_x==0)||(curr_x==h-1)||(curr_y==0)||(curr_y==W-1)) {//벽 끝에 다다르면 
				if(!fire_check) {
					return curr_time;
				}
			}

			if(fire_check) {//불이면,
				for(int k=0;k<4;k++) {
					int fnx=curr_x+dx[k];
					int fny=curr_y+dy[k];
					if(fnx>=0&&fnx<h&&fny>=0&&fny<W&&bd[fnx][fny]=='.') {
						q.add(new Node(fnx,fny,curr_time+1,true));
						bd[fnx][fny]='*';
					}
				}
			}
			
			if(!fire_check) {//상근이면, 
				for(int k=0;k<4;k++) {
					int nx=curr_x+dx[k];
					int ny=curr_y+dy[k];
					if(nx>=0&&nx<h&&ny>=0&&ny<W&&bd[nx][ny]=='.'&&!visited[nx][ny]) {
						q.add(new Node(nx,ny,curr_time+1,false));
						visited[nx][ny]=true;
					}
				}
			}
		}
		return 0;
	}
}
