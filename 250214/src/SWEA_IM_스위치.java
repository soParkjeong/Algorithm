import java.util.Scanner;

public class SWEA_IM_스위치 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		int cnt=0;
		
		for(int t=0;t<T;t++) {	
			int N=sc.nextInt();
			int[] arr1=new int[N];
			int[] arr2=new int[N];
			for(int i=0;i<N;i++) {
				arr1[i]=sc.nextInt();
			}
			for(int i=0;i<N;i++) {
				arr2[i]=sc.nextInt();
			}
			
			cnt=0;
			for(int k=0;k<N;k++) {
				if(arr1[k]!=arr2[k]) {//k번째 자리가 다르면 
					cnt++;
					for(int j=k;j<N;j++) {//k번째 자리부터 다 바꾸
						if(arr1[j]==1) {
							arr1[j]=0;
						}else {
							arr1[j]=1;
						}
					}
				}
			}
			System.out.println("#"+(t+1)+" "+cnt);
		}
		
	}
}
