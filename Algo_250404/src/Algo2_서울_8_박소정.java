import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo2_서울_8_박소정 {
	
//직계가 아니면서 depth가 하나 차이나면 3촌
//bfs 쓰면서 depth 체크하고 
//직계인지 아닌지 여부 체크!
	
	static ArrayList<Integer>[]graph;
	static boolean[] visited;
	static Queue<Node>queue;
	static class Node{
		int node,depth;
		Node(int node,int depth){
			this.node=node;
			this.depth=depth;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();//전체 사람 수=노드 수
			int M=sc.nextInt();//관계의 개수=간선의 수
			
			graph=new ArrayList[N+1];
			visited=new boolean[N+1];
			queue=new LinkedList<>();
			for(int i=0;i<N;i++) {
				graph[i]=new ArrayList<>();
			}//초기화
			
			for(int i=0;i<M;i++) {
				int s=sc.nextInt();
				int e=sc.nextInt();
				graph[s].add(e);
				graph[e].add(s);
			}//양방향 그래프 완성 
			
			queue.add(new Node(1,0));
			visited[1]=true;
			
			System.out.println("#"+tc+" "+bfs());
		}
	}
	static int bfs() {
		int count=0;//3촌의 개수를 저장할 변수 
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			int currNode=node.node;
			int currDepth=node.depth;
			
			if(currDepth)
			for(int next:graph[currNode]) {
				if(!visited[next]) {//방문하지 않은 인접 노드면 
					visited[next]=true;//방문처리해주고 
					queue.add(new Node(next,currDepth+1));//깊이+1해주면서 큐에 넣기 
				}
			}
		}
		return count;
	}
}
