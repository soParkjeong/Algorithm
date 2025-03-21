import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_파리퇴치_복습 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String[] line=br.readLine().split(" ");
			int N=Integer.parseInt(line[0]);
			int M=Integer.parseInt(line[1]);
			int[][]fly=new int[N][N];
			for(int i=0;i<N;i++) {
				String[] arr=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					fly[i][j]=Integer.parseInt(arr[j]);
				}
			}//배열 완성
			
			int[][]sum=new int[N][N];//해당 자리에서 파리채에 의해 죽은 파리의 개수
			int max=0;//최대로 죽은 파리의 개수 
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {//i,j는 내 위치 
					for(int k=0;k<M;k++) {
						for(int l=0;l<M;l++) {//k.l은 내 위치 기준 파리채가 닿는 구간 
							if((i+k<N)&&(j+l<N)) {
								sum[i][j]+=fly[i+k][j+l];
							}
						}
					}
					max=Math.max(max,sum[i][j]);
				}
			}
			System.out.println("#"+(t+1)+" "+max);
		}
	}
}
