import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_햄버거다이어트 {
	static int[]arr;
	static int[][] ingredients;
	static int sum;
	static int score;
	static int max;
	static int N;
	static int L;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String[]str=br.readLine().trim().split(" ");
			N=Integer.parseInt(str[0]);//재료의 수
			L=Integer.parseInt(str[1]);//제한 칼로리 
			
			ingredients=new int[N][2];
			
			for(int i=0;i<N;i++) {
				String[]hb=br.readLine().trim().split(" ");
				ingredients[i][0]=Integer.parseInt(hb[0]);//재료 점수
				ingredients[i][1]=Integer.parseInt(hb[1]);//재료 칼로리
			}
			
			max=0;
			own(0,0,0);
			int result= max;
			System.out.println("#"+tc+" "+result);
		}
	}
	static void own(int j,int score,int sum) {
		//칼로리를 초과하면 return
		if(sum>L) return;
		
		//모든 재료를 확인한 경우
		if(j==N) {
			max=Math.max(max, score);
			return;
		}
		//현재 재료를 선택하는 경우
		own(j+1,score+ingredients[j][0],sum+ingredients[j][1]);//j번째 재료를 선택하면 점수(score)와 칼로리(sum)를 각각 추가한 후, 다음 재료(j+1)로 이
		
		//현재 재료를 선택하지 않는 경우
		own(j+1,score,sum);//j번째 재료를 선택하지 않고 그대로 j+1번째 재료로 이동 
		
	}
}
