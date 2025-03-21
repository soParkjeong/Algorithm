import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SWEA_중위순회 {
	static int[][] tree;
	static HashMap<Integer,String>values;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++) {
			int N=Integer.parseInt(br.readLine());
			tree=new int[N][2];
			
			values=new HashMap<>();
			for(int i=0;i<N;i++) {
				String[] str=br.readLine().split(" ");
				values.put(Integer.parseInt(str[0]),str[1]); 
				if(str.length==4) {
					tree[Integer.parseInt(str[0])][0]=Integer.parseInt(str[2]);
					tree[Integer.parseInt(str[0])][1]=Integer.parseInt(str[3]);
				}else if(str.length==3){
					tree[Integer.parseInt(str[0])][0]=Integer.parseInt(str[2]);
				}
			}//트리 완성
			System.out.print("#"+tc+" ");
			LVR(1,N);
			System.out.println();
		}
	}
	static void LVR(int node,int N) {
		if(node>N) {
			return;
		}
		LVR(node*2,N);
		System.out.print(values.get(node));
		LVR(node*2+1,N);
	}
}
