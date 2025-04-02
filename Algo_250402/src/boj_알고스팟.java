import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class boj_알고스팟 {
	static final int INF=Integer.MAX_VALUE;
	static ArrayList<Edge>[][]graph;
	static int[][]spot;
	static int[][]dist;
	
	static class Edge implements Comparable<Edge>{
		int to_x,to_y,cost;
		public Edge(int to_x,int to_y,int cost) {
			this.to_x=to_x;
			this.to_y=to_y;
			this.cost=cost;
		}
		public int compareTo(Edge e) {
			return Long.compare(this.cost, e.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		//벽을 가중치로 생각하면 되네
		//가장 가중치가 적게 도착지에 가려면 다익스를 쓰자
		//배열의 한 칸을 노드로 보기
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[]NM=br.readLine().trim().split(" ");
		int N=Integer.parseInt(NM[0]);
		int M=Integer.parseInt(NM[1]);
		
		graph=new ArrayList[M+1][N+1];
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				graph[i][j]=new ArrayList<>();
			}
		}//그래프 초기화 
		
		spot=new int[M+1][N+1];//초기화 
		
		for(int i=0;i<M;i++) {
			String[]str=br.readLine().trim().split("");
			for(int j=0;j<N;j++) {
				spot[i][j]=Integer.parseInt(str[j]);
			}
		}//배열 완성
		
		dist=new int[M+1][N+1];//초기화 
		
		for(int i=0;i<M;i++) {
			Arrays.fill(dist[i],INF);
		}//dist 초기화 
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(i-1>=0) graph[i][j].add(new Edge(i-1,j,spot[i-1][j]));
				if(i+1<M) graph[i][j].add(new Edge(i+1,j,spot[i+1][j]));
				if(j-1>=0) graph[i][j].add(new Edge(i,j-1,spot[i][j-1]));
				if(j+1<N) graph[i][j].add(new Edge(i,j+1,spot[i][j+1]));
			}
		}//사방으로 간선 연결 
		
		dijkstra(0,0);
		System.out.println(dist[M-1][N-1]);
	}
	static void dijkstra(int sx,int sy) {
		PriorityQueue<Edge>pq=new PriorityQueue<>();
		
		dist[sx][sy]=0;
		pq.add(new Edge(sx,sy,0));
		
		while(!pq.isEmpty()) {
			Edge e=pq.poll();
			int currNode_x=e.to_x;
			int currNode_y=e.to_y;
			int currCost=e.cost;
			
			if(currCost>dist[currNode_x][currNode_y]) {
				continue;
			}
			
			for(Edge next:graph[currNode_x][currNode_y]) {
				int newDist=dist[currNode_x][currNode_y]+next.cost;
				if(newDist<dist[next.to_x][next.to_y]) {
					dist[next.to_x][next.to_y]=newDist;
					pq.add(new Edge(next.to_x,next.to_y,newDist));
				}
			}
		}
	}
}


