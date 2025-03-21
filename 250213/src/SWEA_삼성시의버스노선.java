import java.util.Scanner;

public class SWEA_삼성시의버스노선 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();

		for(int t=0;t<T;t++) {
			int[] arr=new int[5000];
			int N=sc.nextInt();
			for(int n=0;n<N;n++) {//N개 버스 노선 시작점과 도착점을 받아야 함 
				int a=sc.nextInt();
				int b=sc.nextInt();
				for(int i=a-1;i<=b-1;i++) {//시작점과 도착점까지 배열에 1씩 넣어줌(인덱스여서 -1) 
					arr[i]+=1;
				}
			}
				int p=sc.nextInt();//정류장 개수 
				System.out.print("#"+(t+1)+" ");
				for(int j=0;j<p;j++) {
					int c=sc.nextInt();//정류장 개수 하나씩 입력받고 
					System.out.print(arr[c-1]+" ");//해당 정류장에 담겨있는 버스노선 개수 출
				}
				System.out.println();
		}
	}
}
