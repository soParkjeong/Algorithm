import java.util.Scanner;

public class SWEA_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int[] dr= {0,-1,0,1};
		int[] dc= {1,0,-1,0};
		
		int[][]arr=new int[N][N];
		
		int cnt=1;//값을 적은 횟수
		int x=0;//내 위치 x 좌표 
		int y=0;//내 위치 y 좌표 
		
		int d=0;
		
		while(cnt<=N*N) {
			arr[x][y]=cnt;
			cnt++;
			if((x==N-1)||(y==N-)
			x=x+dr[d%4];
			y=y+dc[d%4];
			d++;
			
		}
	}
}
