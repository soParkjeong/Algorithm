import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_거스름돈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		
		for(int tc=1;tc<=T;tc++) {
			StringBuilder sb=new StringBuilder();
			int money=Integer.parseInt(br.readLine().trim());
			int[]count=new int[8];
			if(money>=50000) {
				count[0]=money/50000;
				money%=50000;
			}

			if(money>=10000) {
				count[1]=money/10000;
				money%=10000;
			}

			if(money>=5000) {
				count[2]=money/5000;
				money%=5000;
			}

			if(money>=1000) {
				count[3]=money/1000;
				money%=1000;
			}

			if(money>=500) {
				count[4]=money/500;
				money%=500;
			}

			if(money>=100) {
				count[5]=money/100;
				money%=100;
			}
			
			if(money>=50) {
				count[6]=money/50;
				money%=50;
			}

			if(money>=10) {
				count[7]=money/10;
				money%=10;
			}
			
			System.out.println("#"+tc);
			for(int i=0;i<8;i++) {
				System.out.print(count[i]+" ");
			}
			System.out.println();
		}
	}
}
