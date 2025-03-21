package study;

import java.util.Scanner;

public class SWEA최빈수 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int tc=sc.nextInt();
			int[]arr=new int[1000];
			
			for(int i=0;i<1000;i++) {
				arr[i]=sc.nextInt();
			}
			
			int[]cnt=new int[101];//0점~100점까지 있으니까 배열길이는 101까지 있어야 100인덱스가 존재 
			for(int c=0;c<1000;c++) {
				cnt[arr[c]]++;//cnt 배열에 빈도수 기록 
			}
			
			//max값 갱신 기법 써도 되지만, 
			//월말평가 1번 풀이처럼 최대 나올 수 있는 횟수가 1000번이니까 1000부터 줄여가면서 내려오다 counting배열 값과 같아지면 출력되는 메커니즘-> 젤 먼저 출력되면 최빈값
			//해당 방식을 사용하면 상위 빈도수 n개를 뽑는 경우에도 사용 가능 
			//실패 
			//해당 경우는 빈도수가 같은 경우가 있으므로 복잡해 
//			for(int num=1000;num>0;num--) {
//				for(int i=0;i<1000;i++) {
//					if(num==cnt[arr[i]]) {
//						System.out.println(arr[i]);
//						break;//젤 먼저 같아지는 값(최빈수)을 출력하고 바로 끝!
//					}
//				}
//			}
			
			//다른 방식으로 cnt 배열 중 max값 찾기
			int max=0;
			for(int i=0;i<1000;i++) {
				if(max<cnt[arr[i]]) {
					max=cnt[arr[i]];//빈도수 중에 최대 빈도수 찾기 
				}
			}
			
			int max_result=0;
			for(int i=0;i<1000;i++) {//최대 빈도 숫자 중 가장 큰 점수 찾기 루프
				if(max==cnt[arr[i]]) {//최대 빈도 숫자와 같은 빈도인 점수일 때,
					if(max_result<arr[i]) {
						max_result=arr[i];//갱신 
					}
				}
			}
			System.out.println("#"+tc+" "+max_result);
		}
	}
}
