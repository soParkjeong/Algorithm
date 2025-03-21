import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SWEA_사칙연산 {
	static int[][]tree;
	static HashMap<Integer,String>values;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++) {
			int N=Integer.parseInt(br.readLine());
			tree=new int[N+1][2];
			values=new HashMap<>();
			for(int i=0;i<N;i++) {
				String[]str=br.readLine().trim().split(" ");
				values.put(Integer.parseInt(str[0]), str[1]);
				if(str.length==4) {
					tree[Integer.parseInt(str[0])][0]=Integer.parseInt(str[2]);
					tree[Integer.parseInt(str[0])][1]=Integer.parseInt(str[3]);
				}
			}
			int result=LVR(1);
			System.out.println("#"+tc+" "+result);
		}
	}
	static int LVR(int node) {
		String value=values.get(node);
		
		if(value.equals("-")||value.equals("+")||value.equals("*")||value.equals("/")) {
			int left=LVR(tree[node][0]);
			int right=LVR(tree[node][1]);
		
			switch(value) {
			case "-": return Math.abs(left-right);
			case "+": return left+right;
			case "*": return left*right;
			case "/": return left/right;
			}
		}
		return Integer.parseInt(value);
	}
}
