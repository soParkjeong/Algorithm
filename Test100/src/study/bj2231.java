package study;

import java.util.Scanner;
import java.util.*;

public class bj2231 {
	public static void main(String[] args) {
		//나 자신(M)+자릿수 값의 합=N
		//M=N의 생성자
		//생성자 구하기
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int result=0;
		int num=0;
		boolean check=false;
		
		//나 자신과 각 자릿수를 더했을 때 입력받은 N이 나와야 함
		//0~9까지 돌아보고 안되면 10곱해서 for문 돌리면서 1의 자리도 0~9까지 for문 돌리면서 해당 숫자와 각 자리수 더해보자 
		//배열 하자
		//배열 인덱스에 넣고 각각 값 더하고 (배열 길이-자기 인덱스-1)*10로 자기 자신 값 만들어서 더하기 
		
		//이건 아니다
		//완전 탐색하자. 생성자가 될 아이는 N보다는 무조건 작을테니까 N까지 for문 돌리면서 i랑 i의 각 자릿수 합이 N이랑 같아지면 break
		// /10해서 나머지는 생성자 요소에 더하고 N=몫 해서 갱신 -> 각 자릿수 + 자기 자신
		for(int i=1;i<=N;i++) {
				num=i;//생성자 후보가 될 num에 i대입 
				result=i;//num과 num의 각 자릿수 합을 담을 변수에 먼저 i대입  
				
			while(num>0) {
				result+=num%10;
				num=num/10;
			}
			if(result==N) {
				System.out.println(i);
				check=true;
				break;
			}
		}
		if(check==false) {
			System.out.println(0);
		}
	}
}
