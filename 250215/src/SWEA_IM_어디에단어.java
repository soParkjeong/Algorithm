import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_IM_어디에단어 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String[] NK=br.readLine().split(" ");
			int N=Integer.parseInt(NK[0]);
			int K=Integer.parseInt(NK[1]);
			int[][] arr=new int[N][N];
			
			for(int i=0;i<N;i++) {
				String[]line=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(line[j]);
				}
			}//배열 완성 
		
			int cnt=0;
			int result=0;
			
			for (int i = 0; i < N; i++) {
			    cnt = 0;
			    for (int j = 0; j < N; j++) {
			        if (arr[i][j] == 1) {
			            cnt++;
			        } else {
			            if (cnt == K) {
			                result++; // 0 만나기 직전 K가 맞으면 카운트
			            }
			            cnt = 0; // 연속이 끊기면 cnt 초기화
			        }
			    }
			    if (cnt == K) { // 배열 끝에서 K가 맞으면 카운트
			        result++;
			    }
			}

			
		
			for (int j = 0; j < N; j++) {
			    cnt = 0;
			    for (int i = 0; i < N; i++) {
			        if (arr[i][j] == 1) {
			            cnt++;
			        } else {
			            if (cnt == K) {
			                result++;
			            }
			            cnt = 0;
			        }
			    }
			    if (cnt == K) {
			        result++;
			    }
			}
			System.out.println("#"+(t+1)+" "+result);
		}
	}
}
