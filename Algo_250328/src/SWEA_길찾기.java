import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_길찾기 {
	static int result;
	static boolean[]visited;
	static ArrayList<ArrayList<Integer>>graph;
	public static void main(String[] args) {
		//단방향 그래프
		//가는길이 있는지 여부만 조사-> DFS지 않을까...?
		//10개의 테스트케이스
		//테스트케이스 번호, 길의 총 개수(간선 개수네)
		//최대 갈림길이 2개
		//인접 리스트 사용하자 
		Scanner sc=new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			int t=sc.nextInt();
			int E=sc.nextInt();//간선 개수
			
			graph=new ArrayList<>();
			
			visited=new boolean[100];
			
			for(int i=0;i<E;i++) {//간선 개수가 순서쌍 개수와 같지!
				graph.add(new ArrayList<>());
				int a=sc.nextInt();
				int b=sc.nextInt();
				graph.get(a).add(b);//단방향 그래프 
			}
			
			result=0;
			dfs(0);
			visited[0]=true;
			System.out.println("#"+t+" "+result);
		}
	}
	static void dfs(int x) {
		//기저조건: x가 99가 되면 
		if(x==99) {
			result=1;
			return;
		}
		
		for(int next : graph.get(x)) {
			if(!visited[next]) {
				visited[next]=true;
				dfs(next);
			}
		}
	}
}
