import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class boj_11399 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine().trim());
		String[]arr=br.readLine().trim().split(" ");
		
		List<Integer>list=new ArrayList<>();
		
		for(int i=0;i<arr.length;i++) {
			list.add(Integer.parseInt(arr[i]));
		}
		
		Collections.sort(list);//정렬 완료

		int[]result=new int[list.size()];
		
		for(int i=0;i<list.size();i++) {
			if(i==0) {
				result[i]=list.get(0);
			}else {
				result[i]=result[i-1]+list.get(i);
			}
		}
		
		int final_result=0;
		for(int i=0;i<result.length;i++) {
			final_result+=result[i];
		}
		System.out.println(final_result);
	}
}
