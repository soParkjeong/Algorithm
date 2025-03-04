import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			int[]arr=new int[N+1];
			for(int i=0;i<N;i++) {
				arr[i+1]=sc.nextInt();
			}
			for(int i=0;i<M;i++) {
				int I=sc.nextInt();
				int J=sc.nextInt();
				for(int k=1;k<=J;k++) {
					if(I-k>0&&I+k<=N) {
						if(arr[I-k]==arr[I+k]) {
							arr[I-k]=1-arr[I-k];
							arr[I+k]=1-arr[I+k];
						}
					}else {
						break;
					}
				}
			}
			System.out.print("#"+tc+" ");
			for(int a=1;a<arr.length;a++) {
				System.out.print(arr[a]+" ");
			}
			System.out.println();
		}
	}
}
