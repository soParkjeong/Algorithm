import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SWEA_규영인영카드게임 {
	static ArrayList<Integer>array;
	static int[]kuyoung;
	static int[]inyoung;
	static boolean[]visited;
	static int winCount, loseCount;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		
		for(int tc=1;tc<=T;tc++) {
			String[]str=br.readLine().trim().split(" ");
			kuyoung=new int[9];
			for(int i=0;i<9;i++) {
				kuyoung[i]=Integer.parseInt(str[i]);
			}//규영카드배열 완성 
			//System.out.println(Arrays.toString(kuyoung));
			
			//인영이가 고를 수 있는 카드 (리스트에 넣기)
			array=new ArrayList<>();
			for(int i=1;i<=18;i++) {
				array.add(i);
			}
			
			//18개 카드 중 규영이가 가져간 카드는 remove
			for(int i=0;i<9;i++) {
				array.remove(Integer.valueOf(kuyoung[i]));
			}
			
			inyoung=new int[9];
			//인영이 카드 순서에 따라 승패 달라짐-> 순열 사용 
			visited=new boolean[array.size()];
			winCount=0;
			loseCount=0;
			
			perm(0);
			
			System.out.println("#"+tc+" "+winCount+" "+loseCount);
			
		}
	}
	//인영이 카드 순열
	static void perm(int idx) {
		//기저 조건
		if(idx==array.size()) {
			card();
			return;
		}
		
		//재귀
		//18P9
		for(int i=0;i<array.size();i++) {
			if(visited[i]) {
				continue;
			}else {
				inyoung[idx]=array.get(i);
				visited[i]=true;
				perm(idx+1);
				inyoung[idx]=0;
				visited[i]=false;
			}
		}
	}
	
	//규영이와 인영이 카드 승패 결정
	static void card() {
		int ku=0;
		int in=0;
		for(int i=0;i<9;i++) {
			if(kuyoung[i]>inyoung[i]) {
				ku+=kuyoung[i]+inyoung[i];
			}else {
				//인영이가 이긴 경우가 곧 규영이가 진 경우 
				in+=inyoung[i]+kuyoung[i];
			}
		}
		if(ku>in) {
			winCount++;
		}else if(ku<in) {
			loseCount++;
		}
	}
}
