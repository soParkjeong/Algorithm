import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_IM_메모리복구 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		int cnt=0;
		for(int t=0;t<T;t++) {
			char[]arr=br.readLine().toCharArray();
			int[]n_arr=new int[arr.length];
			int[]chogi=new int[arr.length];
			for(int i=0;i<arr.length;i++) {
				n_arr[i]=arr[i]-'0';
			}//배열 완료 
			
			cnt=0;
			for(int i=0;i<n_arr.length;i++) {
				if(chogi[i]!=n_arr[i]) {
					cnt++;
					for(int k=i;k<arr.length;k++) {
						if(chogi[k]==0) {
							chogi[k]=1;
						}else {
							chogi[k]=0;
						}
					}
				}
			}
			
			System.out.println("#"+(t+1)+" "+cnt);
		}
	}
}
