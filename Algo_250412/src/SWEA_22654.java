import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_22654 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//G: RC카가 이동 가능한 땅
		//T: RC카가 이동이 불가능한 나무
		//X: 현재 RC카의 위치
		//Y: RC카를 이동 시키고자 하는 위치
		
		//A:앞으로 이동(나무 있는곳, 필드 벗어나는 곳 X)
		//L:현재 바라보고 있는 방향에서 왼쪽으로 90도 회전
		//R:현재 바라보고 있는 방향에서 오른쪽으로 90도 회전 
		
		//항상 위를 바라보는 방향으로 조종을 시작함
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			int N=Integer.parseInt(br.readLine().trim());
			
			int sx=0;
			int sy=0;//출발지
			
			int fx=0;
			int fy=0;//도착
			
			int[][]arr=new int[N][N];
			for(int i=0;i<N;i++) {
				char[]ch=br.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					arr[i][j]=ch[j];
					if(arr[i][j]=='X') {
						sx=i;
						sy=j;
					}
					if(arr[i][j]=='Y') {
						fx=i;
						fy=j;
					}
				}
			}//배열 완성 
			
			int Q=Integer.parseInt(br.readLine().trim());//조종 횟수 Q
			
			
			System.out.print("#"+tc+" ");
			for(int q=0;q<Q;q++) {
				int result=0;//결과  
				
				int cx=sx;
				int cy=sy;//현재 위치 시작점으로 두고 시작 
				
				char dir='U';
				String[]str=br.readLine().trim().split(" ");
				int round=Integer.parseInt(str[0]);//명령 갯수 
			    
				char[]cmd=str[1].toCharArray(); 
			
				//한 라운드(명령) 시작 
				for(int i=0;i<round;i++) {
					char c=cmd[i];//명령 하나 저장 
					if(c=='L') {
						if(dir=='U') dir='L';
						else if(dir=='L') dir='D';
						else if(dir=='D') dir='R';
						else if(dir=='R') dir='U';
					}else if(c=='R') {
						if(dir=='U') dir='R';
						else if(dir=='R') dir='D';
						else if(dir=='D') dir='L';
						else if(dir=='L') dir='U';		
					}else if(c=='A') {
						int nx=cx;
						int ny=cy;
						if(dir=='U') nx--;
						else if(dir=='D') nx++;
						else if(dir=='L') ny--;
						else if(dir=='R') ny++;
						
						if(nx>=0&&nx<N&&ny>=0&&ny<N&&arr[nx][ny]!='T') {
							cx=nx;
							cy=ny;//현재 위치 갱신 
						}
					}
				}
				//도착지에 갔는지 체크
				if(cx==fx&&cy==fy) {
					System.out.print(1+" ");
				}else {
					System.out.print(0+" ");
				}
			}
			System.out.println();
		}
	}
}
