import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1149 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[][]arr=new int[N][3];
		for(int i=0;i<N;i++) {
			String[]str=br.readLine().trim().split(" ");
			for(int j=0;j<3;j++) {
				arr[i][j]=Integer.parseInt(str[j]);
			}
		}//배열 완성 
		
		int[][]h_color=new int[N][3];//최소 비용 저장 배열 
		
		//첫번째 집의 각 색칠 비용은 주어진 비용과 동일 
		h_color[0][0]=arr[0][0];
		h_color[0][1]=arr[0][1];
		h_color[0][2]=arr[0][2];
		
		for(int i=1;i<N;i++) {
			h_color[i][0]=Math.min(h_color[i-1][1], h_color[i-1][2])+arr[i][0];//현재 집이 빨강이려면, 전 집이 초록,파랑 중 작은 값 + 빨간색 비용 
			h_color[i][1]=Math.min(h_color[i-1][0], h_color[i-1][2])+arr[i][1];
			h_color[i][2]=Math.min(h_color[i-1][0], h_color[i-1][1])+arr[i][2]; 
		}
		
		//젤 작은 비용(삼중비교)
		int result=Math.min(Math.min(h_color[N-1][0],h_color[N-1][1]),h_color[N-1][2]);
		System.out.println(result);
	}
}
