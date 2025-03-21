import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_IM_단조증가 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine().trim());
			String[] line=br.readLine().trim().split(" ");
			int[]arr=new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(line[i]);
			}//배열에 넣기
			
			int danjo=0;
			int max=0;
			int k=Integer.MAX_VALUE;
			boolean check=true;
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					danjo=arr[i]*arr[j];
					check=true;
					k=Integer.MAX_VALUE;
					int n_danjo=danjo;
					while(n_danjo>0) {
						int a=n_danjo%10;//마지막 자릿 수 추출 
						if(k>=a) {
							k=a;
						}else {
							check=false;
							break;
						}
						n_danjo=n_danjo/10;//단조 갱신 
					}
					if(check) {
						max=Math.max(max,danjo);
					}
				}
			}
			if(max==0) {
				System.out.println("#"+(t+1)+" "+-1);
			}else {
				System.out.println("#"+(t+1)+" "+max);
			}
		}
	}
}
