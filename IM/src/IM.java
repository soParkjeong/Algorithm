import java.util.Scanner;

public class IM {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int N=sc.nextInt();
			int[][]arr=new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=sc.nextInt();
				}
			}//배열 완성
			
			int[]dr= {-1,1,0,0};
			int[]dc= {0,0,-1,1};
			int x=0;
			int y=0;
			int min=Integer.MAX_VALUE;
			int[][]cnt=new int[N][N];
			int m_x=0;
			int m_y=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					//boolean flag=true;
					x=i;
					y=j;//현재 좌표 넣어주기

					outter:
					while((x<N && x>=0 && y<N && y>=0)) { //벽에 닿기 전까지 
						min=Integer.MAX_VALUE;//최솟값 초기화 
						boolean check=false;//사방탐색 결과 나보다 작은 값의 유무 체크 변수
						for(int k=0;k<4;k++) {//내 자리 기준 사방 탐색 
							int new_x=x+dr[k];
							int new_y=y+dc[k];
							if(new_x<N && new_x>=0 && new_y<N && new_y>=0) {
								if(arr[new_x][new_y]<arr[x][y]) {//나보다 작으면 
									check=true;//나보다 작은 값 유 표시 
									min=Math.min(min, arr[new_x][new_y]);
									m_x=new_x;
									m_y=new_y;
								}
							}
						}
						if(check==false) {//사방 탐색 해봤을 때 나보다 작은게 없는 경우 
							break outter;
						}else {
							cnt[i][j]++;//i,j 좌표에서 시작한 길의 이동거리에 더해주기 
							for(int k=0;k<4;k++) {
								if(x+dr[k]<N && x+dr[k]>=0 && y+dc[k]<N && y+dc[k]>=0) {
									if(min==arr[x+dr[k]][y+dc[k]]) {
										x=x+dr[k];
										y=y+dc[k];
									}
								}
							}
						}
					}
				}
			}
			int max=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					max=Math.max(max, cnt[i][j]+1);
				}
			}
			System.out.println("#"+(t+1)+" "+max);
		}
	}
}
