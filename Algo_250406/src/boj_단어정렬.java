import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class boj_단어정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		
		Set<String>set=new HashSet<>();
		
		for(int t=0;t<T;t++) {
			set.add(br.readLine().trim());
		}
		
		List<String>list=new ArrayList<>(set);//리스트로 변환해서 set 넣기
		Collections.sort(list,new Comparator<String>(){
			public int compare(String s1,String s2) {
				if(s1.length()!=s2.length()) {
					return s1.length()-s2.length();//길이 순 
				}else {
					return s1.compareTo(s2);//사전 순 -compareTo 메서드 내에 이미 사전순으로 정렬되도록 설계되어있음 
				}
			}
		});
		
		for(String str:list) {
			System.out.println(str);
		}
		
	}
}
