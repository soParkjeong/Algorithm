import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_IM_어디에단어 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		
		for(int t=0;t<T;t++) {
			String[] line=br.readLine().trim().split(" ");
			int N=Integer.parseInt(line[0]);
			int K=Integer.parseInt(line[1]);
			int[][] arr=new int[N][N];
			
			for(int i=0;i<N;i++) {
				String[] str=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(str[j]);
				}
			}//배열 완성
			
			int cnt=0;
			
			for(int i=0;i<N;i++) {
				cnt=0;
				for(int j=0;j<N;j++) {
					for(int k=0;k<N;k++) {
						if(j+k<N) {
							if(arr[i][j+k]==1) {
								cnt++;
							}else {
								break;
							}
						}
					}
					if(cnt!=3) {
						
					}
				}                  
			}
		}
	}
}

