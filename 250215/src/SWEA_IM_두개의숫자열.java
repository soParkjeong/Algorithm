import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_IM_두개의숫자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String[] line=br.readLine().split(" ");
			int N=Integer.parseInt(line[0]);
			int M=Integer.parseInt(line[1]);
			
			int[] N_arr=new int[N];
			String[] N_str=br.readLine().split(" ");
			for(int i=0;i<N;i++) {
				N_arr[i]=Integer.parseInt(N_str[i]);
			}//N배열 완성 
			
			int[] M_arr=new int[M];
			String[] M_str=br.readLine().split(" ");
			for(int i=0;i<M;i++) {
				M_arr[i]=Integer.parseInt(M_str[i]);
			}//M배열 완성
			
			int max_sum=0;
			int sum=0;
			if(N<M) {
				for(int count=0;count<Math.abs(M-N)+1;count++) {
					sum=0;
					for(int k=0;k<N;k++) {
						sum+=N_arr[k]*M_arr[k+count];
					}
					max_sum=Math.max(sum, max_sum);
				}
			}else {
				for(int count=0;count<Math.abs(M-N)+1;count++) {
					sum=0;
					for(int k=0;k<M;k++) {
						sum+=N_arr[k+count]*M_arr[k];
					}
					max_sum=Math.max(sum, max_sum);
				}
			}
			System.out.println("#"+(t+1)+" "+max_sum);
		}
	}
}
