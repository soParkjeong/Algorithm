import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWEA_젤다 {
	static final int INF=Integer.MAX_VALUE;
	static ArrayList<Edge>[][]graph;
	static int[][]cave;
	static int[][]dist;
	
	static class Edge implements Comparable<Edge> {//연결노드를 담는 리스트에 엣지 객체가 연결노드로 담김 
		int to_x,to_y,cost;
		Edge(int to_x,int to_y,int cost){
			this.to_x=to_x;
			this.to_y=to_y;
			this.cost=cost;
		}
		public int compareTo(Edge e) {
			return Long.compare(this.cost, e.cost);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=1;
		int tc=1;
		
		while(true) {
			T=Integer.parseInt(br.readLine().trim());
			if(T==0) {
				break;
			}
			
			graph=new ArrayList[T][T];
			for(int i=0;i<T;i++) {
				for(int j=0;j<T;j++) {
					graph[i][j]=new ArrayList<>();
				}
			}//초기화 
			
			cave=new int[T][T];//도둑루피 크기가 담긴 동굴 배열 
			for(int i=0;i<T;i++){
				String[]str=br.readLine().trim().split(" ");
				for(int j=0;j<T;j++) {
					cave[i][j]=Integer.parseInt(str[j]);
				}
			}//배열 완성 
			
			dist=new int[T][T];
			for(int i=0;i<T;i++) {
				Arrays.fill(dist[i], INF);
			}//가중치 배열 초기화(INF로)
			
			for(int i=0;i<T;i++) {
				for(int j=0;j<T;j++) {
					if(i-1>=0) graph[i][j].add(new Edge(i-1,j,cave[i-1][j]));
					if(i+1<T) graph[i][j].add(new Edge(i+1,j,cave[i+1][j]));
					if(j-1>=0) graph[i][j].add(new Edge(i,j-1,cave[i][j-1]));
					if(j+1<T) graph[i][j].add(new Edge(i,j+1,cave[i][j+1]));
				}
			}//인접 사방 양방향 노드 연결 
			
			dijkstra(0,0);
			System.out.println("Problem"+" "+tc+":"+" "+dist[T-1][T-1]);
			tc++;
		}
	}
	
	static void dijkstra(int sx,int sy) {
		PriorityQueue<Edge>pq=new PriorityQueue<>();
		
		dist[sx][sy]=cave[sx][sy];
		pq.add(new Edge(sx,sy,cave[sx][sy]));
		
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
