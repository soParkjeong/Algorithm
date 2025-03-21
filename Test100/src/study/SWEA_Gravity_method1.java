package study;

import java.util.Scanner;
//방법 1: 메모리 오류 뜸(메모리 과하게 사용하는 문제 취급)
public class SWEA_Gravity_method1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int length=sc.nextInt();
			int[][]arr=new int[length][100];
			
			for(int c=0;c<length;c++) {
				//행 제한:length(i)
				//열 제한:100(j)
				int x=sc.nextInt();
				//주어진 길이만큼 1로 채우기(그 외는 원래 0으로 채워져있음)
				for(int i=0;i<x;i++) {
					arr[c][i]=1;
				}
			}//건물 길이만큼 1로 채워짐, 그 외는 0
			
			int j=0;//j: 열의 인덱스 
			int index_y=0;//건물의 젤 위 지점 
			int index_x=0;
			int cnt=0;//0의 개수
			int[] count=new int[length];//0의 개수 세서 넣을 배열 
			
			for(int i=0;i<length;i++) {
				//1로 채워진 가장 끝 지점에서 아래로 0이 몇 칸인지 세기
				if(arr[i][0]==0) {//아예 건물이 없는 곳은 건너뛰기 
					count[i]=0;
					continue;
				}else {
					j=0;
					while((j<100)&&(arr[i][j]!=0)) {
						j++;
					}
					index_y=j-1;
					cnt=0;
					for(int k=i+1;k<length;k++) {
						if(arr[k][index_y]==0) {
							cnt++;
						}
					}
					count[i]=cnt;
				}
			}
			
			int max=0;
			for(int r=0;r<length;r++) {
				if(max<count[r]) {
					max=count[r];
				}
			}
			System.out.println("#"+(t+1)+" "+max);
		}
		
	}
}
