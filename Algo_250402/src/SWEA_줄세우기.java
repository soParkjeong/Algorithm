import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_줄세우기 {
	static int N;
	static ArrayList<Integer>[]graph;
	static ArrayList<Integer>[]revGraph;
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
			N=sc.nextInt();//정점의 개수
			int M=sc.nextInt();//간선의 개수라고 생각
			
			graph=new ArrayList[N+1];
			revGraph=new ArrayList[N+1];
			
			for(int i=0;i<N+1;i++) {
				graph[i]=new ArrayList<>();
				revGraph[i]=new ArrayList<>();
			}//초기화
			
			for(int i=0;i<M;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				
				graph[a].add(b);//단향 그래프(나보다 큰 개수를 세는 용)-시작점을 기준으로 갈 수 있는 곳이 곧 시작점보다 큰 노드들 
				revGraph[b].add(a);//단향 그래프(나보다 작은 개수를 세는 용)-시작점을 기준으로 역으로 갈 수 있는 곳이 곧 시작점보다 작은 노드들 
			}
			
			int cnt=0;
			for(int i=1;i<=N;i++) {
				int bigCnt=bfs(i,graph);
				int smallCnt=bfs(i,revGraph);
				
				if(bigCnt+smallCnt==N-1) {
					cnt++;
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
	
	static int bfs(int start, ArrayList<Integer>[] adj) {
		Queue<Node>	q=new LinkedList<>();
		boolean[]visited=new boolean[N+1];
		q.add(new Node(start,0));
		visited[start]=true;
		
		int count=0;
		
		while(!q.isEmpty()) {
			Node node=q.poll();
			int currNode=node.node;
			int currDepth=node.depth;
			
			for(int next:adj[currNode]) {
				if(!visited[next]) {
					visited[next]=true;
					q.add(new Node(next,currDepth+1));
					count++;//방문 가능한 학생 증가 
				}
			}
		}
		return count;
	}
}
