import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			
			boolean check=true;
			for(int i=0;i<N;i++){
				int k=M%2;
				if(k==0) {
					check=false;
				}
				M=M/2;
			}
			
			String result="";
			if(check) {
				result="ON";
			}else {
				result="OFF";
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}