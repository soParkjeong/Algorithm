import java.util.Arrays;

public class java_조합 {
	static String[] 재료= {"상추","패티","토마토","치즈"};//data
	static String[] sel;//햄버거를 만드는 재료
	static int N,R;//N:전체 재료의 수, R:내가 뽑을 재료의 수 
	
	public static void main(String[] args) {
		N=4;
		R=2;
		재료=new String[] {"상추","패티","토마토","치즈"};
		sel=new String[R];
		
		comb(0,0);
	}//main
	
	//idx: 내가 이번에 고려할 재료들의 인덱스(재귀의 깊이)
	//sidx: 뽑은 재료의 인덱스 
	public static void comb(int idx,int sidx) {
		System.out.println(idx+" "+sidx);
		//종료 조건
		if(sidx==R) {
			//재료선정 완료!
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx==N) {
			//더 이상 고려할 재료가 없어!
			return;
		}
		//재귀조건
		sel[sidx]=재료[idx];
		comb(idx+1,sidx+1);//뽑는 경우
		
		//sel[sidx]=null;//재료를 사용하지 않은 경우(불필요한 경우)-어차피 덮어버림 
		comb(idx+1,sidx);//안뽑는 경우
	}
}