import java.util.Arrays;
import java.util.Scanner;

public class bj_1654 {
	public static void main(String[] args) {
		//802+743+457+539
		//457/2=228
		//802/228=3
		//743/228=3
		//539/228=2
		//젤 작은것의 중간값으로 나눈 몫의 합<N이면,
		//중간값=중간값-1/2
		//나머지 숫자들/중간값의 몫의 합>N이면, 
		//중간값=중간값+1/2
		Scanner sc=new Scanner(System.in);
		int K=sc.nextInt();//주어진 자르기 전 랜선 개수 
		int N=sc.nextInt();//필요한 랜선 개수 
		int sum=0;//랜선 개수 
		
		int[] arr=new int[K];
		for(int i = 0;i<K;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);//배열 정렬(오름차순) 
		
		int k=1;//나누는 수 
		int idx=0;//나누어지는 수 위치 
		int mid=0;
		while(sum!=N) {
			mid=arr[idx]/k;//작은 값부터 쪼개서 기준 길이 갱신 
			for(int i=0;i<arr.length;i++) {
				sum+=arr[i]/mid;
			}
			if(sum<N) {
				if(k<arr[arr.length-1]) {
					++k;//자른 개수가 목표 개수(N)보다 적으면 쪼개는 기준 길이 줄여서 개수 늘리기
				}
			}else {
				if(idx<N-1) {
					idx++;//자른 개수가 목표 개수(N)보다 많으면 쪼개는 기준 길이 늘려서 개수 줄이기 
					k=1;//새로운 랜선을 쪼개기로 했으므로 k 값 초기화 
				}
			}
		}
		System.out.println(mid);
	}
}
