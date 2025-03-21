import java.util.Scanner;

public class bj1568 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int num=1;
		int cnt=0;

		while(N>0) {
			if(N<num) {
				num=1;//남은 새의 수보다 num보다 작으면 num=1로 초기
			}
			N=N-num;
			num++;
			cnt++;

		}
		System.out.println(cnt);
	}
}
