import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_신뢰 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine().trim());
		
		for(int t=0;t<TC;t++) {
			//B랑 O배열 따로 담아주기
			char[] line=br.readLine().toCharArray();
			int length=line[0]-'0';
			Character[] Barr=new Character[length];
			Character[] Oarr=new Character[length];
			
			int b_idx=0;
			int o_idx=0;
			for(int i=1;i<=length*2;i++) {
				if(line[i]=='B') {
					Barr[b_idx]=line[i+1];
					b_idx++;
				}
				if(line[i]=='O') {
					Oarr[o_idx]=line[i+1];
				}
			}//B랑 O 버튼 위치 다 담음
			
			int sum=0;
			
			for(int k=0;k<Barr.length;k++) {
				for(int l=0;l<Oarr.length;l++) {
					if(Barr[k]==Oarr[l]) {
						
						sum=Barr[k]+Oarr[l];
					}
				}
			}
		}
	}
}
