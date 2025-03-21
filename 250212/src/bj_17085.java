import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_17085 {
	public static void main(String[] args) throws IOException {
		//#이 있는 곳으로 가면 탐색 시작
		//상하좌우 탐색 
		//상,하,좌,우 중 옆으로 가지 못하면 다음 #장소로 이동
		//상,하,좌,우 탐색하면서 길이를 늘려가다가 더 이상 #이 나오지 않으면 스탑
		//상,하,좌,우가 모두 동일한 만큼 길이를 늘려야 함
		//하나라도 더 이상 길이를 늘릴 수 없으면 stop 하고 다음 #장소로 이동
		//모든 곳을 다 탐색했는데 하나의 십자가만 완성된 경우 다른 하나의 십자가 넓이는 1
		//모든 곳을 다 탐색했는데 십자가가 하나도 완성되지 않은 경우의 두개의 십자가 넓이는 모두 1
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] church = new char[N][M];

        // 체스판 입력 받기
        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
            	church[i][j] = line.charAt(j);
            }
        }
        
        int cnt=1;//상하좌우 이동횟수 
        boolean check=true;//사방에 다 #이 있는 곳인지 아닌지 표시 
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		int[] dr= {-1,1,0,0};
        		int[] dc= {0,0,-1,1};

        		int new_x=0;
        		int new_y=0;
        		
        		//끝에 부딪힐때까지 확장하기 
        		while(new_x<N && new_x>=0 && new_y<N && new_y>=0) {
        			for(int k=0;k<4;k++) {
        				new_x=i+dr[k]*cnt;
        				new_y=j+dc[k]*cnt;
        				//상하좌우 탐색하는데 상하좌우 모두 한바퀴 돌면서 탐색 후에 모두 #이 위치하면 cnt++해서 탐색범위 한칸씩 넓히
        				if(church[new_x][new_y]!='#') {
        					check=false;
        				}
        			}
        			if(check==true) {
        				cnt++;//상하좌우 모두 #이면 탐색 범위 up
        			}else {
        				break;
        			}
        		}
        		
        		//1이상의 넓이를 가진 경우 
        		//내 자리에서 만들 수 있는 십자가의 넓이 경우의 수가 cnt+1 개수 만큼 있음
        		
        		
        		
        	}
        }
	}
}
