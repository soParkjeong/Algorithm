package study;

import java.util.Scanner;

public class SWEA중간값 {
	public static void main(String[] args) {
		//배열 길이: N
		//Arrays.sort 방법 외로 풀어보자 
		//버블정렬로 오름차순으로 정렬 후 홀수 개만 주어지니까 N/2번째 인덱스가 중간값 
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		int temp=0;
		for(int i=1;i<N;i++) {
			for(int j=0;j<N-i;j++) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.print(arr[N/2]);
	}
}
