import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_contact {
	//넓게 퍼져나가되, 가장 나중에 연락받는 사람이어야 하니까 depth가 가장 큰거 고르는건가
	//depth가 가장 큰 노드가 여러 개일 땐 그 중 번호가 가장 큰 노드?
	//BFS?
	//연락받았던 사람은 다시 못받으니까 visited로 처리
	static ArrayList<ArrayList<Integer>>graph;
	static Queue<Node>queue;
	static ArrayList<Boolean>visited;
	static class Node{
		int node, depth;
		
		Node(int node,int depth){
			this.node=node;
			this.depth=depth;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int E=sc.nextInt();//간선 개수로 치자 
			int S=sc.nextInt();//시작정점 
			
			graph=new ArrayList<>();
			visited=new ArrayList<>();
			
			for(int i=0;i<=100;i++) {//노드 최대 100개 
				graph.add(new ArrayList<>());//초기화 
				visited.add(false);//초기화 
			}
			
			for(int i=0;i<E/2;i++) {
				int s=sc.nextInt();
				int e=sc.nextInt();
				graph.get(s).add(e);
			}//그래프 완성 
			
			queue=new LinkedList<>();
			queue.add(new Node(S,0));
			visited.set(S, true);//시작점 방문처리하고 시작 
			
			System.out.println("#"+tc+" "+bfs());
		}
	}
	
	static int bfs() {
		int maxDepth=-1;//가장 깊은 걸 저장하기 위한 변수 
		int answer=-1;//가장 번호가 큰 사람 저장하기 위한 변수 
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			
			int currNode=node.node;
			int currDepth=node.depth;
			
			if(currDepth>maxDepth) {
				maxDepth=currDepth;
				answer=currNode;
			}else if(currDepth==maxDepth) {//가장 깊은 노드가 여러 개 일땐 번호가 큰 노드 선택 
				if(currNode>answer) {
					answer=currNode;
				}
			}
			
			for(int next:graph.get(currNode)) {
				if(!visited.get(next)) {
					visited.set(next,true);
					queue.add(new Node(next,currDepth+1));
				}
			}
		}
		return answer;
	}
}
