import java.util.ArrayList;
import java.util.List;

public class 조합04_중복조합 {
	static String[] 재료= {"상추","패티","토마토","치즈"};//data
	static int N,R;//N:전체 재료의 수, R:내가 뽑을 재료의 수 
	static List<List<String>> result;//List의 요소가 List
	
	public static void main(String[] args) {
		N=4;
		R=2;
		재료=new String[] {"상추","패티","토마토","치즈"};
		
		result=new ArrayList<>();
		
		combcomb(0,new ArrayList<String>());
		
		for(List<String> tmp:result) {
			System.out.println(tmp);
		}
	}//main
	
	//current:임시 리스트/ 배열로 처리, 동등 인덱스 필요할지도
	public static void combcomb(int start,List<String>current) {
		//종료조건
		if(current.size()==R) {
			result.add(new ArrayList<>(current));
			List<String>tmp=new ArrayList<>();
//			for(String str:current) {
//				tmp.add(str);
//			}
//			result.add(tmp);
			return;
		}
		
		//재귀조건
		for(int i=start;i<N;i++) {
			current.add(재료[i]);//재료 넣기
			combcomb(i,current);//중복 허용이니 i를 다시 고려하도록
			current.remove(current.size()-1);//재료 빼기
		}
	}
}

