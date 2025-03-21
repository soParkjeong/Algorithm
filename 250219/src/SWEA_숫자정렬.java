import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class SWEA_숫자정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		//굳이 LinkedList 써보자
		
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine().trim());
			String[]line=br.readLine().split(" ");
			LinkedList<Integer>list=new LinkedList<>();
			for(int i=0;i<N;i++) {
				list.add(Integer.parseInt(line[i]));
			}
			
			int min=Integer.MAX_VALUE;
			int m_idx=0;
			int size=N;
			System.out.print("#"+(t+1)+" ");
			while(!list.isEmpty()) {
				min=Integer.MAX_VALUE;
				for(int n=0;n<size;n++) {
					if(min>list.get(n)) {
						min=list.get(n);
						m_idx=n;
					}
				}
				System.out.print(list.get(m_idx)+" ");
				list.remove(m_idx);
				size--;
			}
			System.out.println();
		}
	}
}
