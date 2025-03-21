import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SWEA_A_보물상자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String[] line=br.readLine().split(" ");
			int N=Integer.parseInt(line[0]);
			int K=Integer.parseInt(line[1]);
			Set<Integer>f_arr=new HashSet<>();//중복없어야 하니까 set
			int idx=0;
			
			int sum=0;
			char[] arr=br.readLine().toCharArray();
			char[] n_arr=arr;
			for(int i=0;i<N/4;i++) {
				for(int j=0;j<N;j+=N/4) {//j+(N/4)칸 이동해서 다음 (N/4)개 받아오기 
					for(int k=0;k<N/4;k++) {
						char ch=n_arr[j+k];//N/4개 중 하나씩 받아와서 16진수로 전환 
						if(ch>= 'A' && ch <= 'F') {
							sum+=(ch-'A'+10)*Math.pow(16,(N/4-1)-k);//알파벳이면 10진수로 변환 후 16진수로 변환 
						}else {
							sum+=(ch-'0')*Math.pow(16, (N/4-1)-k);
						}
					}
					f_arr.add(sum);//f_arr목록에 16진수 저장
					sum=0;
				}
				char temp=n_arr[N-1];//마지막 요소 임시 저장 
				for(int l=N-1;l>0;l--) {
					n_arr[l]=n_arr[l-1];//한 칸씩 뒤로 이동 
				}
				n_arr[0]=temp;
			}
			List<Integer> sortedList = new ArrayList<>(f_arr);
            Collections.sort(sortedList, Collections.reverseOrder());
            
            System.out.println("#" + (t+1) + " " + sortedList.get(K - 1));
		}
	}
}
