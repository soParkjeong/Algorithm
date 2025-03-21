import java.util.Scanner;

public class boj_2798_블랙잭 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int[] arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		int diff=0;
		int min=Integer.MAX_VALUE;
		
		int sum=0;
		int result=0;
		
		for(int i=0;i<N-2;i++) {
			for(int j=i+1;j<N-1;j++) {
				for(int k=j+1;k<N;k++) {
					sum=arr[i]+arr[j]+arr[k];//3장의 카드의 합 
					if(sum<=M) {//3장의 합이 M을 넘지 않을 때 
						diff=M-sum;//M과의 차이가 최소일 때 
						if(min>diff) {
							min=diff;
							result=sum;
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}
