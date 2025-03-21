import java.util.Scanner;

public class SWEA_IM_간단한369 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int k=0;
		int cnt=0;//-개수 
		boolean check=false;//369가 들어간 숫자인지 체크 

		for(int i=1;i<=N;i++) {
			check=false;//369가 들어간 숫자인지 체크해주는 변수 초기화 
			cnt=0;//-개수를 세 줄 변수 초기화 
			int check_369=i;//i 갱신 혼선방지
			while(check_369>0) {
				k=check_369%10;//자릿수 추출 
				if((k==3)||(k==6)||(k==9)) {
					cnt++;
					check=true;//3,6,9중 하나라도 있으면 
				}
				check_369=check_369/10;
			}
			if(check) {
				for(int t=0;t<cnt;t++) {
					System.out.print('-');
				}
			}else {
				System.out.print(i+" ");
			}
		}
	}
}
