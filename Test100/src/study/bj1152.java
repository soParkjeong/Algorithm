package study;

import java.util.Scanner;

public class bj1152 {
	public class Main {
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			
			String a=sc.nextLine().trim();//trim(): 좌우 공백 제
			
			String[] arr = a.split(" ");//split(" "): 공백을 기준으로 쪼개기

			//a에 아무것도 없으면 0을 반
			// 단독으로 입력되면 길이는 0
			if(a=="") {
				System.out.print(0);
			}else {
				System.out.print(arr.length);
			}
			
		}
	}
	//로직은 간단한데 답이 틀린 경우에는 최소값에서 반례가 있을 것!!
}
