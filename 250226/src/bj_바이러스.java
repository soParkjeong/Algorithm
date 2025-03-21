import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj_바이러스{
	static ArrayList<Integer>[] computer;
	static boolean[] visited;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());//정점 개수
		int K=Integer.parseInt(br.readLine());//간선 개수 
		visited=new boolean[N+1]; 
		
		computer=new ArrayList[N+1];
		ofor(int i=1;i<=N;i++) {
			computer[i]=new ArrayList<>();
		}
		
		for(int i=0;i<K;i++) {
			String[] st=br.readLine().trim().split(" ");
			int u=Integer.parseInt(st[0]);
			int v=Integer.parseInt(st[1]);
			
			computer[u].add(v);
			computer[v].add(u);
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(computer[i]);
		}
		
		cnt=0;
		int result=dfs(1);
		System.out.println(result-1);//나 자신 빼주기 
	}
	
	static int dfs(int start) {
		int current=start;
		visited[current]=true;
		cnt++;
		
		for(int n_computer:computer[current]) {
			if(!visited[n_computer]) {
				dfs(n_computer);
			}
		}
		return cnt;
	}
}
