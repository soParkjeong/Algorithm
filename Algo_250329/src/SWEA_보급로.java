import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SWEA_보급로 {
	static int[][]bg;
		//출발지가 정해져있고, 도착지까지 가는 최단경로니까 다익스쓰자
		//깊이가 1이라면 복구에 드는 시간 1
		//깊이=가중치로 치자
		//좌상단:출발지, 우하단:도착지 
	static class Edge implements Comparable<Edge>{
		//배열 한 칸을 노드 번호(0~N*N-1번)로 매기자 
		//안되네,,,그냥 노드 x좌표, y좌표로 쪼개서 보자 
		int to_x,to_y;
		int cost;
		public Edge(int to_x,int to_y,int cost) {
			this.to_x=to_x;
			this.to_y=to_y;
			this.cost=cost;
		}
		public int compareTo(Edge e) {
			return this.cost-e.cost;
		}
	}
	
	static final int INF=Integer.MAX_VALUE;
	static int V,E;
	//배열 한 칸을 노드로 보자 
	static List<Edge>[][]adj;
	static int[][]dist;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			int N=Integer.parseInt(br.readLine().trim());
			bg=new int[N][N];
			
			for(int i=0;i<N;i++) {
				char[]ch=br.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					bg[i][j]=ch[j]-'0';
				}
			}//보급로 배열 완성 
			
			adj=new ArrayList[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					adj[i][j]=new ArrayList<>();
				}
			}
			
			dist=new int[N][N];
			//이차원 배열 Arrays.fill이다!
			for(int i=0;i<N;i++) {
				Arrays.fill(dist[i], INF);
			}
			
			//사방향으로만 간선 연결되네,,
			//다익스는 단방향 그래프 
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					//안 넘치게 
					if(i+1<N) adj[i][j].add(new Edge(i+1,j,bg[i][j]));
					if(i-1>=0) adj[i][j].add(new Edge(i-1,j,bg[i][j]));
					if(j-1>=0) adj[i][j].add(new Edge(i,j-1,bg[i][j]));
					if(j+1<N) adj[i][j].add(new Edge(i,j+1,bg[i][j]));
				}
			}
			
			dijkstra(0,0);
			System.out.println("#"+tc+" "+dist[N-1][N-1]);
		}
	}
	
	static void dijkstra(int sx,int sy) {
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		
		dist[sx][sy]=0;//출발 노드의 최단 거리는 0 
		pq.add(new Edge(sx,sy,0));//시작점을 먼저 넣기 
		
		while(!pq.isEmpty()) {
			Edge current=pq.poll();
			int curNode_x=current.to_x;
			int curNode_y=current.to_y;
			int curCost=current.cost;
			
			if(curCost>dist[curNode_x][curNode_y]) {
				continue;
			}
			
			for(Edge next:adj[curNode_x][curNode_y]) {
				int newDist=dist[curNode_x][curNode_y]+next.cost;
				if(newDist<dist[next.to_x][next.to_y]) {
					dist[next.to_x][next.to_y]=newDist;
					pq.add(new Edge(next.to_x,next.to_y,newDist));
				}
			}
		}
	}
	
}
