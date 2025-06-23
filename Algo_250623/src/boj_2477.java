import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int K=Integer.parseInt(br.readLine().trim());
		
		int[]dir=new int[6];
		int[]length=new int[6];
		
		for(int i=0;i<6;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			dir[i]=Integer.parseInt(st.nextToken());
			length[i]=Integer.parseInt(st.nextToken());
		}
		
		int maxG=0;
		int maxS=0;
		int maxGIdx=0;
		int maxSIdx=0;
		
		for(int i=0;i<6;i++) {
			if(dir[i]==1||dir[i]==2) {
				if(length[i]>=maxG) {
					maxG=length[i];
					maxGIdx=i;
				}
			}
			if(dir[i]==3||dir[i]==4) {
				if(length[i]>=maxS) {
					maxS=length[i];
					maxSIdx=i;
				}
			}
		}
		
		int totalSquare=maxG*maxS;

		// 작은 사각형의 가로, 세로 계산
        int minG = Math.abs(length[(maxSIdx + 1) % 6] - length[(maxSIdx + 5) % 6]);
        int minS = Math.abs(length[(maxGIdx + 1) % 6] - length[(maxGIdx + 5) % 6]);
        int minSquare = minG * minS;

        int result = (totalSquare - minSquare) * K;
        
        System.out.println(result);
		
	}
}
