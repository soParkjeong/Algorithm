import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1753 {
	static class Node implements Comparable<Node>{
		int vertex,cost;
		
		public Node(int vertex, int cost) {
			this.vertex=vertex;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.cost,other.cost);
		}
	}
	
	static int[] dijkstra(int start, List<List<Node>> graph, int v) {
		PriorityQueue<Node> pq=new PriorityQueue<>();//우선순위 큐
		int[] dist=new int[v+1];//정점의 개수만큼 거리 배열 선언(최소 거리만 들어가게 갱신될 배열))
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[start]=0;//시작 정점 start의 거리는 0으로 설정
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node current=pq.poll();//현재 비용이 가장 작은 노드를 꺼냄
			int curVertex=current.vertex;//큐에서 꺼낸 노드의 정점을 현재 정점으로
			int curCost=current.cost;//큐에서 꺼낸 노드의 가중치를 현재 가중치로 
			
			if(curCost>dist[curVertex]) continue;//더 크면 갱신해주면 안됨 
			
			for(Node neighbor:graph.get(curVertex)) {//시작 정점에 인접한 노드를 모두 체크 
				int newCost=curCost+neighbor.cost;//인접노드의 가중치에 현재 가중치를 더한 것을 새로운 가중치로 구함
				
				if(newCost<dist[neighbor.vertex]) {//만약에 새로운 가중치가 더 작음녀 
					dist[neighbor.vertex]=newCost;//새로운 거리를 갱신 
					pq.offer(new Node(neighbor.vertex,newCost));
				}
			}
		}
		return dist;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int E=sc.nextInt();
		int K=sc.nextInt();
		
		List<List<Node>> graph=new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int distance = sc.nextInt();
            graph.get(start).add(new Node(end, distance));
        }
		
		int[] shortestPaths=dijkstra(K,graph,v);
		
		for(int i=1;i<=v;i++) {
			if(shortestPaths[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(shortestPaths[i]);
			}
		}
	}
}
