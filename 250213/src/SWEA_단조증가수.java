import java.util.Scanner;

public class SWEA_단조증가수 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0;t<T;t++) {
			int N=sc.nextInt();
			int[] arr=new int[N];
			
			//N개의 개수만큼 A 후보 담기 
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}

			int danjo=0;
			boolean check=true;
			int n_max=0;//단조수 저장 
			int max=0;//단조수 중에서 최댓값 저장 
			
			for(int idx=0;idx<N-1;idx++) {
				for(int j=idx+1;j<N;j++) {
					if(idx<j) {
						danjo=arr[idx]*arr[j];
					}
					
					int a=30001;//마지막 자리 수랑 비교할 대상을 정수 범위보다 더 큰 수로 잡기 
					int n_danjo=danjo;//단조 수가 while문 돌면서 갱신되니까 얕은 복사해서 원본은 변동되지 않게
					check=true;//check도 초기화 
					
					//단조수인지 체크
					while(n_danjo>0) {
						int tmp=n_danjo%10;//마지막 자리 수 추출 
						if(tmp>a) {//마지막 자리 수가 a보다 크면 단조 아님 
							check=false;
							break;
						}else {
							a=tmp;//a를 마지막 자리 수로 갱신 
							n_danjo=n_danjo/10;//단조 수 갱신 
						}
					}
					
					if(check) {
						n_max=danjo;
					}
					max=Math.max(n_max, max);
				}
			}
			
			//max값이 한번도 갱신되지 않았다면 즉, 단조수가 발견되지 않았다면, max=-1이니
			if(max==0) {
				System.out.println(-1);
			}else {
				System.out.println("#"+(t+1)+" "+max);
			}
		}
	}
}
