import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_사람네트워크2 {
	static int[][]graph;
	static boolean[]visited;
	static int N;
	static Queue<Node>q;
	
	static class Node{
		int node,depth;
		Node(int node,int depth){
			this.node=node;
			this.depth=depth;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		
		for(int tc=1;tc<=T;tc++) {
			String[]str=br.readLine().trim().split(" ");
			
			N=Integer.parseInt(str[0]);
			
			graph=new int[N+1][N+1];
			
			int index=1;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					graph[i][j]=Integer.parseInt(str[index++]);
				}
			}//배열 완성, 양방향 그래프 자동 연결 완료
			
			int min=Integer.MAX_VALUE;
			for(int i=1;i<=N;i++) {
				int result=bfs(i);
				if(min>result) {
					min=result;
				}
			}
			System.out.println("#"+tc+" "+min);
		}
	}
	
	static int bfs(int start) {
		visited=new boolean[N+1];
		q=new LinkedList<>();
		int cnt=0;
		
		q.add(new Node(start,0));
		visited[start]=true;
		
		while(!q.isEmpty()) {
			Node node=q.poll();
			
			int currNode=node.node;
			int currDepth=node.depth;
			
			cnt+=currDepth;
			
			for(int i=1;i<=N;i++) {
				if(graph[currNode][i]==1) {
					if(!visited[i]) {
						visited[i]=true;
						q.add(new Node(i,currDepth+1));
					}
				}
			}
		}
		return cnt;
	}
}
