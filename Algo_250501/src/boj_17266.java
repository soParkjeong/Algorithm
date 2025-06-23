import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17266 {
	public static void main(String[] args) throws IOException {
		//가로등을 설치할 개수 M
		//각 가로등의 위치 x
		//최소한의 높이로 모든 굴다리 밝히기
		//가로등 높이가 모두 같아야 함 
		
		//가로등 가장 앞 좌표에서 0에 닿을 때까지 얼마 걸리는지
		//가로등 가장 뒤 좌표에서 젤 끝에 닿을 때까지 얼마 걸리는지
		//가로등 간 사이 간격 이 세개 대소비교해서 젤 긴거가 답 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); 
		int M = Integer.parseInt(br.readLine());

		int[] arr = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max=0;
		 for (int i = 1; i < M; i++) {
			 	int dist = arr[i] - arr[i - 1];
				int f_dist = (dist + 1) / 2; 
	            max = Math.max(max, f_dist);
	        }
		 
		int f=arr[0];
		int b=N-arr[arr.length-1];
		
		max=Math.max(Math.max(f, b),max);
		
		System.out.println(max);
	}
}
