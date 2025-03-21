import java.util.Scanner;

public class SWEA_공통조상 {
	static int[][]tree;
	static int[] parent_A;
	static int[] parent_B;
	static int idx;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int V=sc.nextInt();//정점 개수 
			int E=sc.nextInt();//간선 개수 
			
			tree=new int[V+1][3];
			
			int A=sc.nextInt();
			int B=sc.nextInt();
			
			for(int i=1;i<V;i++) {
				int p=sc.nextInt();
				int c=sc.nextInt();
				if(tree[p][0]==0) {
					tree[p][0]=c;
				}else {
					tree[p][1]=c;
				}
				tree[c][2]=p;
			}//node 채우기 
			
			int target=0;
			cnt=1;
			parent_A=new int[V+1];
			parent_B=new int[V+1];
			
			find_A(A,V);
			idx=0;
			find_B(B,V);
			outter:
			for(int i=0;i<parent_A.length;i++) {
				for(int j=0;j<parent_B.length;j++) {
					if(parent_A[i]==0||parent_B[j]==0) {
						continue;
					}//부모가 둘 다 0인 상태(즉, 부모가 없는 상태)를 동일한 부모라고 인
					if(parent_A[i]==parent_B[j]) {
						target=parent_A[i];
						break outter;
					}
				}
			}
			System.out.println("#"+tc+" "+target+" "+subtree(target));
		}
	}
	static void find_A(int A,int V) {
		if(tree[A][2]!=0) {
			parent_A[idx]=tree[A][2];
			idx++;
			find_A(tree[A][2],V);
		}
	}
	static void find_B(int B,int V) {
		if(tree[B][2]!=0) {
			parent_B[idx]=tree[B][2];
			idx++;
			find_B(tree[B][2],V);
		}
	}
	static int subtree(int node) {
		for(int i=0;i<=1;i++) {
			if(tree[node][i]!=0) {
				cnt++;
				subtree(tree[node][i]);
			}
		}
		return cnt;
	}
}
