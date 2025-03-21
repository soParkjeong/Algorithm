package study;

import java.util.Scanner;

public class SWEA_Gravity_method2 {
	public static void main(String[] args) {
//2중 for문을 사용하되, 일일히 1을 담고 그러지 않고 좌표로 보기
//길이를 배열로 받기-> 좌표로 치고 오른쪽으로 건물 개수 세기 
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int cnt=0;
		int max=0;
		
		for(int t=0;t<T;t++) {
			int n=sc.nextInt();
			int[]cnt_arr=new int[n];
			int[]arr=new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}//건물 높이를 담은 배열 생성
			
			for(int a=0;a<n;a++) {
				cnt=0;
				for(int b=a+1;b<n;b++) {
					if(arr[a]>arr[b]) {
						cnt++;
					}
				}
				cnt_arr[a]=cnt;
			}
			
			max=0;
			for(int r=0;r<n;r++) {
				if(max<cnt_arr[r]) {
					max=cnt_arr[r];
				}
			}
			System.out.println("#"+(t+1)+" "+max);
		}
	}
}

