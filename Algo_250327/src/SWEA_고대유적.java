import java.util.Scanner;

public class SWEA_고대유적 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			int[][]picture=new int[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					picture[i][j]=sc.nextInt();
				}
			}//배열 완성 
			
			int max=0;

			int[]dx= {-1,1,0,0};
			int[]dy= {0,0,-1,1};
			
			int cnt=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(picture[i][j]==1) {
						int cx=i;
						int cy=j;
						for(int k=0;k<4;k++) {
							cnt=1;
							while(true) {
								int nx=cx+dx[k]*cnt;
								int ny=cy+dy[k]*cnt;
								if(nx>=0 && nx<N && ny>=0 && ny<M && picture[nx][ny]==1) {
									cnt++;
								}else {
									break;
								}
							}
							if(max<cnt) {
								max=cnt;
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
