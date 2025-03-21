import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj_1003 {
	static int[] memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int n=Integer.parseInt(br.readLine().trim());

			int[]fibo=new int[n+2];
				
			fibo[0]=0;
			fibo[1]=1;
				
			for(int j=2;j<=n;j++) {
				fibo[j]=fibo[j-1]+fibo[j-2];
			}
				
			if(n==0) {
				System.out.println(1+" "+0);
			}else {
				System.out.println(fibo[n-1]+" "+fibo[n]);
			}
		}
	}

}
