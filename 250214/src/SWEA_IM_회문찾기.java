import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_IM_회문찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine().trim());
		boolean check=false;
		
		for(int t=0;t<T;t++) {
			check=false;
			System.out.print("#"+(t+1)+" ");
			String[] line=br.readLine().split(" ");
			int N=Integer.parseInt(line[0]);
			int M=Integer.parseInt(line[1]);
			char[] arr=br.readLine().toCharArray();
			outter:
			for(int i=0;i<N-(M-1);i++) {
				if(arr[i]==arr[i+(M-1)]) {
						check=true;
						for(int k=0;k<M;k++) {
							System.out.print(arr[i+k]);
						}
						break outter;
				}
			}
			
			if(check==false) {
				System.out.print("NONE");
			}
			System.out.println();
		}
	}
}
