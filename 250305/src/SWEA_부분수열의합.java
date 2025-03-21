import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_부분수열의합 {
	static int N;
	static int K;
	static int cnt;
	static int sum;
	static int[]array;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String[]str=br.readLine().trim().split(" ");
			N=Integer.parseInt(str[0]);
			K=Integer.parseInt(str[1]);
			String[]arr=br.readLine().trim().split(" ");
			array=new int[N];
			for(int i=0;i<arr.length;i++) {
				array[i]=Integer.parseInt(arr[i]);
			}
			
			cnt=0;//카운트 초기화 
			cnt_array(0,0);
			int result=cnt;
			System.out.println("#"+tc+" "+result);
		}
	}
	static void cnt_array(int j,int sum) {
		if(sum==K) {
			cnt++;
		}
		if(j==N) {
			return;
		}
		cnt_array(j+1,sum+array[j]);
		cnt_array(j+1,sum);
	}
}
