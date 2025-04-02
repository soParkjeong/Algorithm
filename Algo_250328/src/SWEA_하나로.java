import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_하나로 {
	//long 쓰자
	//하나로 다 연결해야 하니까 MST
	//노드 번호가 아니라 좌표로 주어짐 
	//길 가중치=점과 점 사이 거리 
	static class Edge implements Comparable<Edge> {
        int to;
        long cost; 

        public Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }
	
	public static void main(String[] args) {
		//하나로-모든 섬 연결-MST
		//프림 사용하자
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();//정점의 개수 
			
			List<Edge>[]adj=new ArrayList[N];
			
			for(int i=0;i<N;i++) {
				adj[i]=new ArrayList<>();//인접 리스트 초기화 
			}
			
			int[][]points=new int[N][2];
			for(int i=0;i<N;i++) {
				points[i][0]=sc.nextInt();//노드별 x좌표 쭈르륵 저장 
			}
			for(int i=0;i<N;i++) {
				points[i][1]=sc.nextInt();//노드별 y좌표 쭈르륵 저장 
			}
			
			//두 점 사이 거리 공식써서 가중치로 저장하자(루트는 안해도 되겠지,,, 어차피 상대적 가중치비교만 하면 되니까)
			//아 해저터널 길이 제곱의 곱만큼 지불한다는게 루트 안해주려고 그렇네,,,
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					long dx = points[i][0] - points[j][0];
                    long dy = points[i][1] - points[j][1];
                    long cost = dx * dx + dy * dy; 
					//프림은 양방향!
					adj[i].add(new Edge(j,cost));
					adj[j].add(new Edge(i,cost));
				}
			}
			
			double E=sc.nextDouble();
			
			long L=prim(N,adj);
			long result=Math.round(E*L);
			
			System.out.println("#"+tc+" "+result);
		}
	}
	
	private static long prim(int V, List<Edge>[] adj) {
		long ans=0;//최소 비용 저장 변수(오버플로우 조심)
		PriorityQueue<Edge>pq=new PriorityQueue<>();
		boolean[]visited=new boolean[V];
		
		pq.addAll(adj[0]);//0번 정점부터 시작 
		visited[0]=true;//0번 노드 방문 처리 
		int pick=1;
		
		while(pick<V) {
			Edge e=pq.poll();
			if(visited[e.to]) {
				continue;
			}
			
			ans+=e.cost;
			visited[e.to]=true;
			pick++;
			pq.addAll(adj[e.to]);
		}
		return ans;
	}
}
