import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_Sum_복습 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int[][] arr=new int[100][100];
		
		for(int t=0;t<10;t++) {
			int T=Integer.parseInt(br.readLine());
			for(int i=0;i<100;i++) {
				String[] line=br.readLine().split(" ");
				for(int j=0;j<100;j++) {
					arr[i][j]=Integer.parseInt(line[j]);
				}
			}//배열 완성
		
			int[]sum1=new int[100];//행 별 합 
			int[]sum2=new int[100];//열 별 합 
			int sum3=0;//대각선1 별 합 
			int sum4=0;//대각선2 별 합 
			int max1=0;
			int max2=0;
			int max3=0;
			int f_max=0;
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					sum1[i]+=arr[i][j];
					max1=Math.max(max1,sum1[i]);
				}
			}
			f_max=Math.max(f_max,max1);
		
			for(int j=0;j<100;j++) {
				for(int i=0;i<100;i++) {
					sum2[j]+=arr[i][j];
					max2=Math.max(max2,sum2[j]);
				}
			}
			f_max=Math.max(f_max,max2);
		
			int x=0;
			int y=99;
			for(int i=0;i<100;i++) {
				sum3+=arr[i][i];
				sum4+=arr[x++][y--];
			}
			max3=Math.max(sum3, sum4);
			f_max=Math.max(f_max,max3);
			
			System.out.println("#"+(T+1)+" "+f_max);
		}
	}
}
