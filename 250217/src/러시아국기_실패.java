import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 러시아국기_실패 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		
		for(int t=0;t<T;t++) {
			String[] str=br.readLine().trim().split(" ");
			int N=Integer.parseInt(str[0]);
			int M=Integer.parseInt(str[1]);
			char[][] arr=new char[N][M];
			for(int i=0;i<N;i++) {
				char[]line=br.readLine().trim().toCharArray();
				for(int j=0;j<M;j++) {
					arr[i][j]=line[j];
				}
			}//배열 완성
			
			int cnt=0;
	
			for(int j=0;j<M;j++) {
				if(arr[0][j]!='W') {//첫 줄은 무조건 W
					arr[0][j]='W';
				}
				if(arr[N-1][j]!='R') {//마지막 줄은 무조건 R
					arr[N-1][j]='R';
				}
			}
			
			int f_cnt=0;//새로 칠해야 하는 칸의 개수 
			char[] color=new char[N];//행 별 색깔을 담은 배열  
			color[0]='W';
			color[N-1]='R';
			int cntW=0;
			int cntWB=0;
			int cntBB=0;
			int cntR=0;
			for(int i=1;i<N-1;i++) {//나머지 줄은 개수 비교 후 색 결정 
				for(int j=0;j<M;j++) {
					for(int k=0;k<M;k++) {
						if((color[i-1]=='W')&&arr[i][k]=='W') {
							cntW++;
						}else if((color[i-1]=='W')&&arr[i][k]=='B') {
							cntWB++;
						}else if((color[i-1]=='B')&&arr[i][k]=='B') {
							cntBB++;
						}else if((color[i-1]=='B')&&arr[i][k]=='R') {
							cntR++;
						}
					}
					if(cntW>cntWB) {//W의 개수가 더 많으면 W로 변환 
						if((color[i-1]=='W')&&arr[i][j]!='W') {//이전 줄이 W이면서 W가 아닌 자리는 
							arr[i][j]='W';//W로 전환 
							color[i]='W';//해당 열은 W색으로 지정 
							f_cnt++;
						}
					}else {//B의 개수가 더 많으면 B로 변환 
						if((color[i-1]=='W')&&arr[i][j]!='B') {//이전 줄이 W이면서 B가 아닌 자리는 
							arr[i][j]='B';//B로 전환 
							color[i]='B';//해당 열은 B색으로 지정 
							f_cnt++;
						}
					}
					
					if(cntBB>cntR) {//B가 R보다 많으면 
						if((color[i-1]=='B')&&arr[i][j]!='B') {//이전 줄이 B이면서 B가 아닌 자리는 
							arr[i][j]='B';//B로 전환 
							color[i]='B';//해당 열은 B색으로 지정 
							f_cnt++;
						}
					}else {//B의 개수가 더 많으면 B로 변환 
						if((color[i-1]=='B')&&arr[i][j]!='R') {//이전 줄이 B이면서 R가 아닌 자리는 
							arr[i][j]='R';//R로 전환 
							color[i]='R';//해당 열은 R색으로 지정 
							f_cnt++;
						}
					}
				}
			}
			System.out.println("#"+(t+1)+" "+f_cnt);
		}	
	}
}
