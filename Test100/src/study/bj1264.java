package study;

import java.util.Scanner;

public class bj1264 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int cnt=0;
		
		//charAt()으로 한 알파벳씩 보기 
		//nextLine()은 개행문자까지 가져오니까 개행 문자 나올때까지 while문 돌아가게 해서 모음 개수 세기 
		while(true) {
			String str=sc.nextLine();
			cnt=0;
			
			if(str.equals("#")) {
				break;
			}

			for(int i=0;i<str.length();i++) {
				str=str.toLowerCase();
				if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'|str.charAt(i)=='o'||str.charAt(i)=='u') {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
