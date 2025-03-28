import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_노드의거리 {
	static Queue<Node>queue;
	static ArrayList<Integer>[]graph;
	static boolean[] visited;
	static int V;
	static int G;
	
	static class Node{
		int node,cnt;
		Node(int node,int cnt){
			this.node=node;
			this.cnt=cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int cnt=0;
			
			queue=new LinkedList<>();
			
			V=sc.nextInt();
			int E=sc.nextInt();
			
			graph=new ArrayList[V+1];//인덱스 1번부터 채워넣기 때문에 길이 +1 
			visited=new boolean[V+1];
			
			for(int i=1;i<=V;i++) {//인덱스 1번부터 채워넣기 
				graph[i]=new ArrayList<>();	
			}
			
			for(int i=0;i<E;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				graph[a].add(b);
				graph[b].add(a);//무방향 그래프니
				
			}//출발노드가 곧 그래프 인접리스트의 인덱스, 출발노드에 연결된 노드들이 각 해당 인덱스에 리스트로 들어가 있음
			
			int S=sc.nextInt();
			G=sc.nextInt();
			
			visited[S] = true;
			queue.add(new Node(S, 0));

			
			int result=bfs();
			System.out.println("#"+tc+" "+result);
		}
		
	}
	static int bfs() {
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			
			if(node.node==G) {
				return node.cnt;
			}
			
			for(int next : graph[node.node]) {
				if(!visited[next]) {
					visited[next]=true;
					queue.add(new Node(next,node.cnt+1));
				}
			}
		}
		return 0;
	}
}