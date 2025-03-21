package 과목평가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class cat {
	static ArrayList<String>[]cat;
	static String[]home;
	static int N;
	static int[] result;
	static boolean[] visited;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			N=Integer.parseInt(br.readLine().trim());//고양이 수 
			home=br.readLine().trim().split(" ");//집이 갖고 있는 고양이 털 색 저장
			
			cat=new ArrayList[N];//털 종류 저장할 리스트 
			//고양이 털 종류를 담은 리스트를 담은 고양이 배열(배열 길이: 고양이 수) 
			for(int i=0;i<N;i++) {
				String[]hair=br.readLine().trim().split(" ");
				cat[i]=new ArrayList<>();//cat 배열 내 리스트 하나 가져와서 초기화
				for(int j=1;j<hair.length;j++) {//털 종류를 리스트에 담기 
					cat[i].add(hair[j]);
				}
			}//배열 완성
			
			cnt=0;
			result=new int[N];
			visited=new boolean[N];
			perm(0);
			System.out.println("#"+tc+" "+cnt);
		}
	}
	
	static void perm(int idx) {
		if(idx==N) {
			cnt++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i] && cat[i].contains(home[idx])) {
				result[idx]=i;
				visited[i]=true;
				
				perm(idx+1);
					
				visited[i]=false;
			}
		}
	}
}
