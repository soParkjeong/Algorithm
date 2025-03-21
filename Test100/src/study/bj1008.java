package study;

import java.util.Scanner;

public class bj1008 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int A=sc.nextInt();
		int B=sc.nextInt();
		
		//double result=(double)A/B;
		
		//System.out.printf("%f", result); //double 값을 소수점 6자리까지 출력하는 형식
		System.out.println((double)A/B); //Java의 기본 double 형식으로 출력(소수점이 길면 그대로 출력)
		
		
	}
}
//로직은 간단한데 답이 틀린 경우에는 최소값에서 반례가 있을 것!!
