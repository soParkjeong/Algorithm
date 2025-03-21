import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_4008 {
	static boolean[] visited;
	static char[] operators; 
	static char[]select;
	static int[]num;
	static int max_cnt;
	static int min_cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb=new StringBuilder();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			int N=Integer.parseInt(br.readLine().trim());
			
			String[] str=br.readLine().trim().split(" ");
			
			//System.out.println(length);
			max_cnt=Integer.MIN_VALUE;
			min_cnt=Integer.MAX_VALUE;
			
			operators = new char[N-1];
            int index = 0;
            for (int i = 0; i < Integer.parseInt(str[0]); i++) operators[index++] = '+';
            for (int i = 0; i < Integer.parseInt(str[1]); i++) operators[index++] = '-';
            for (int i = 0; i < Integer.parseInt(str[2]); i++) operators[index++] = '*';
            for (int i = 0; i < Integer.parseInt(str[3]); i++) operators[index++] = '/';
			
			String[] str_arr=br.readLine().trim().split(" ");
			num=new int[str_arr.length];

			for(int i=0;i<str_arr.length;i++) {
				num[i]=Integer.parseInt(str_arr[i]);
			}
			
			select=new char[num.length-1];
			visited=new boolean[operators.length];
			
			perm(0);
			//최대값이 되는 순열 찾기 
			sb.append("#").append(tc).append(" ").append(max_cnt-min_cnt).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void perm(int count) {
		if(count==num.length-1) {//기저 조건(부호는 숫자 개수-1개 뽑아야 함) 
			calculate();
			return;
		}
		
		for(int i=0;i<operators.length;i++) {
            if (!visited[i]) { // 방문하지 않은 연산자만 선택
                visited[i] = true;  // 선택 표시
                select[count] = operators[i];
                perm(count + 1);
                visited[i] = false; // 원상복구 (백트래킹)
            }
		}
	}
	
	public static void calculate() {
		int result=num[0];
		for(int i=0;i<select.length;i++) {
			if(select[i]=='+') {
				result+=num[i+1];
			}else if(select[i]=='-') {
				result-=num[i+1];
			}else if(select[i]=='*') {
				result*=num[i+1];
			}else {
				if(num[i+1]!=0) {
					result/=num[i+1];
				}else {
					return;
				}
			}
		}
		if(max_cnt<result) {
			max_cnt=result;
		}
		if(min_cnt>result) {
			min_cnt=result;
		}
	}
}
