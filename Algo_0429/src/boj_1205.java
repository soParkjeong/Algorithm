import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1205 {
	public static void main(String[] args) throws IOException {
		//내림차순 
		//같은 점수가 있을 때는 그러한 점수의 등수 중에 가장 작은 등수
		//랭킹 리스트에 올라갈 수 있는 점수 개수 P
		//리스트에 있는 점수 N개가 비오름차순으로 주어짐
		//태수의 새로운 점수가 랭킹 리스트에서 몇 등하는
		//P와 N이 같으면(즉,랭킹 리스트가 꽉 차있으면) 태수 점수가 이전 점수보다 좋을 때만 갱신
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int ts=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		
		int result=0;
		
		if(N==0) {
			result=1;
		}else {
			ArrayList<Integer>list=new ArrayList<>();
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			if(N<P) {//리스트에 있는 점수 개수가 모두 올라갈 수 있거나, 여유가 있을 때는 무조건 태수 점수 기입 가능 
				list.add(ts);
				Collections.sort(list, Collections.reverseOrder());
				int rank=1;
				for(int score:list) {
					if(score==ts) {
						break;
					}
					rank++;
				}
				result=rank;
			}else if(N==P){
				Collections.sort(list);//오름차순으로 정렬했을 때,제일 앞에 있는 것보다 태수가 작으면 -1 
				if(list.get(0)>=ts) {
					result=-1;
				}else {
					list.add(ts);
					Collections.sort(list, Collections.reverseOrder());
					int rank=1;
					for(int score:list) {
						if(score==ts) {
							break;
						}
						rank++;
					}
					result=rank;
				}
			}
		}
		System.out.println(result);
	}
}
