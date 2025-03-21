import java.util.Scanner;

public class bj1731 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int[] arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		int diff1=0;
		int diff2=0;
		boolean check=true;
		int result=0;
		
		for(int j=0;j<N-2;j++) {
			if(arr[j+1]/arr[j]==arr[j+2]/arr[j+1]) {
				diff1=arr[j+1]/arr[j];
			}
			if(arr[j+1]-arr[j]==arr[j+2]-arr[j+1]) {
				diff2=arr[j+1]-arr[j];
				check=false;
			}
			
			if(check==true) {
				result=arr[N-1]*diff1;
			}else {
				result=arr[N-1]+diff2;
			}
		}
		System.out.println(result);
	}
}
