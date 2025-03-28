import java.util.Scanner;

public class SWEA_고대유적2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			
			int[][]picture=new int[N][M];
			
			int max=0;
			int cnt=0;
			
			int cx=0;
			int cy=0;
			
			int[]dx= {-1,1,0,0};
			int[]dy= {0,0,-1,1};
			
			boolean check=false;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					picture[i][j]=sc.nextInt();
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(picture[i][j]==1) {
						cx=i;
						cy=j;
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
							if(cnt>=2) {
								check=true;
							}
							if(max<cnt) {
								max=cnt;
							}
						}
					}
				}
			}
			
			if(check) {
				System.out.println("#"+tc+" "+max);
			}else {
				System.out.println("#"+tc+" "+0);
			}
		}
	}
}
