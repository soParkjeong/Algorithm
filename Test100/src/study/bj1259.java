package study;

import java.util.*;

public class bj1259 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean result=false;
		int a=1;
		
		while(a!=0){
			//반복문 돌 때마다 result값 초기화 
			result=false;
			a=sc.nextInt();
			//정수로 받은 값을 맨 앞과 맨 뒤자리부터 하나씩 비교하기 위해 문자열로 변환 
			//주의!길이가 홀수여야지만 팰린드롬 아님!! 초반 실수..
			String arr=Integer.toString(a);
			for(int i=0;i<arr.length();i++) {
				//맨 앞과 맨 뒤에서 한칸씩 앞으로 오면서 비교 
				if(arr.charAt(i)==arr.charAt(arr.length()-1-i)) {
					result=true;
				}else {
					result=false;
					break;
				}
			}
			//a가 0일때 반복문(while)은 종료하나,출력하고 종료되는 것을 방지하기 위해 a가 0이 아닐 때 출력하는 조건문 추
			if(a!=0) {
				if(result==true){
					System.out.println("yes");
				}else{
					System.out.println("no");
				}
			}
		}
		
	}
}
