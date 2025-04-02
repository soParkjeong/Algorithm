import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_특정한최단경로 {
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Edge>[] graph;
	static int[] dist;
	static int V;

	static class Edge implements Comparable<Edge> {
		int to, cost;

		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		public int compareTo(Edge e) {
			return Long.compare(this.cost, e.cost);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();// 정점의 개수
		int E = sc.nextInt();// 간선의 개수

		graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		} // 초기화

		dist = new int[V + 1];
		Arrays.fill(dist, INF);// 초기화

		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int cost = sc.nextInt();
			graph[s].add(new Edge(e, cost));
			graph[e].add(new Edge(s, cost));// 양방향 간선 연결
		}

		int V1 = sc.nextInt();
		int V2 = sc.nextInt();
		int result = dijkstra(1, V1, V2);
		System.out.println(result);
	}

	static int dijkstra(int start, int V1, int V2) {
		int result = -1;
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		dist[start] = 0;// 시작->시작으로 갈 때는 제자리니까 가중치 0
		pq.add(new Edge(start, 0));// 시작점을 우선순위 큐에 넣기

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			int currNode = e.to;
			int currCost = e.cost;

			if (currCost > dist[currNode]) {
				continue;
			}

			for (Edge next : graph[currNode]) {// next:Edge 객체형태
				int newDist = dist[currNode] + next.cost;
				if ((next.to == V1) || (next.to == V2)) {
					dist[next.to] = newDist;
					pq.add(new Edge(next.to, newDist));
				} else {
					if (newDist < dist[next.to]) {
						dist[next.to] = newDist;
						pq.add(new Edge(next.to, newDist));
					}
				}
			}
		}
		result = dist[V];
		return result;
	}
}
