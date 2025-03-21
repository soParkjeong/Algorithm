import java.util.Scanner;

public class SWEA_공통조상 {
	static int[][] tree;
	static int cnt=1;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0;t<T;t++) {
			int V=sc.nextInt();
			int E=sc.nextInt();
			int A=sc.nextInt();
			int B=sc.nextInt();
			
			int[][]tree=new int[V+1][3];
			for(int i=0;i<V-1;i++) {
				int p=sc.nextInt();
				int c=sc.nextInt();
				if(tree[i][0]==0) {
					tree[i][0]=c;//왼쪽 자식 
				}else {
					tree[i][1]=c;//오른쪽 자식 
				}
				tree[i][2]=p;//부모 채우기 
			}
		
			cnt=1;
			while(findChild(findParent(A))==B) {//A의 조상이 B를 갖고 있을 때까지 
				
			}
			
		}
	}
	
	static int findParent(int Node) {//findParent 메서드의 return값은 Node 매개변수로 들어온 값의 조상 
		return tree[Node][2];//현재 인덱스를 자식으로 부모 찾기
	}
	
	static int findChild(int Node) {//findChild 메서드의 return값은 Node 매개변수로 들어온 값의 자손 
		for(int i=0;i<=1;i++) {
			if(tree[Node][i]!=0) {
				findChild(tree[Node][i]);
			}
		}
		return tree[Node][i];
	}
}
