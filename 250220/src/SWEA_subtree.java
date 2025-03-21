import java.util.Scanner;

public class SWEA_subtree{
	static int[][]tree;
	static int cnt;

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0;t<T;t++) {
			int E=sc.nextInt();//간선 개수
			int N=sc.nextInt();//지정한 노드 
			tree=new int[E+2][3];//[왼쪽 자식, 오른쪽 자식, 부모]
			//E+2인 이유: E는 간선 개수, 노드 개수는 간선 개수+1-> tree 크기는 간선 개수-1
			
			//E개의 (부모, 자식) 쌍 입력받기
			//트리는 노드 개수(V)보다 간선 개수(E)가 하나 적어야 하니까,
			//노드 개수(V)=E+1이고, 반복문을 E번(V-1번)돌려서 부모-자식 관계를 저장하는 것임
			for(int i=0;i<E;i++){
				int p=sc.nextInt();//부모 노드
				int c=sc.nextInt();//자식 노드
				
				//왼쪽 자식부터 저장
				if(tree[p][0]==0){
					tree[p][0]=c;
				}else{
					tree[p][1]=c;//(이미 채워졌다면 오른쪽 자식)
				}
				
				//부모 정보 저장
				tree[c][2]=p;
			}
			
			cnt=1;
			subtree(N);
			System.out.println("#"+(t+1)+" "+cnt);
		}
		sc.close();
	}
	//subtree 탐색 메서드 
	static void subtree(int Node) {
		for(int idx=0;idx<=1;idx++) {//왼쪽(0), 오른쪽(1) 자식만 탐색  
			if(tree[Node][idx]!=0) {//자식이 있으면 
				cnt++;
				subtree(tree[Node][idx]);//현재 인덱스를 부모로 거기에 연결된 자식이 있는지 탐색하기 위해 다시 subtree 메서드 호출 
			}
		}
	}
}
