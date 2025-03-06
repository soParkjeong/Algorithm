import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			int t=sc.nextInt();
			int N=sc.nextInt();
			int M=sc.nextInt();
			System.out.println("#"+t+" "+pow(N,M));

		}
	}
		
		static int pow(int N,int M) {
			if(M==1) return N;
			
			if(M%2==1) {
				return pow(N,(M-1)/2)*pow(N,(M-1)/2)*N;
			}else {
				return pow(N,M/2)*pow(N,M/2);
			}
		}
		
		static int pow2(int N,int M) {
			if(M==1) return N;
			
			if(M%2==1) {
				int tmp=pow2(N,(M-1)/2);
				return tmp*tmp*N;
			}else {
				int tmp=pow2(N,M/2);
				return tmp*tmp;
			}
		}
	}

