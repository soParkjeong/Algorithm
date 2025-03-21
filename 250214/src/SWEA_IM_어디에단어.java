import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_IM_어디에단어 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String[] str=br.readLine().split(" ");
			int N=Integer.parseInt(str[0]);
			int k=Integer.parseInt(str[1]);
			int[][]arr=new int[N][N];
			
			for(int i=0;i<N;i++) {
				String[]line=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(line[j]);
				}
			}//배열 완성 
			
			int cnt=0;
			int result=0;
			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					//가로 체크 
					cnt=0;
					if(arr[x][y]==1) {
						for(int i=0;i<k;i++) {
							if(y+i<N) {
								if(arr[x][y+i]==1) {
									cnt++;
								}else {
									break;
								}
							}
						}
					}
					if(cnt==k) {
						result++;
					}else {
						break;
					}
				}
			}
			
			for(int y=0;y<N;y++) {
				for(int x=0;x<N;x++) {
					//세로 체크 
					if(arr[x][y]==1) {
						cnt=0;
						for(int j=0;j<k;j++) {
							if(x+j<N) {
								if(arr[x+j][y]==1) {
									cnt++;
								}else {
									break;
								}
							}
						}
					}
					if(cnt==k) {
						result++;
					}else {
						break;
					}
				}
			}
			System.out.println("#"+(t+1)+" "+result);
		}				
	}
}
