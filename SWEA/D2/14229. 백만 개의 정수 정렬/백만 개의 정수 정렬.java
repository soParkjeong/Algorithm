import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[] A=new int[1000000];
		String[]array=br.readLine().trim().split(" ");
		for(int i=0;i<1000000;i++) {
			A[i]=Integer.parseInt(array[i]);
		}
		
		q_s(A,0,A.length-1);
		
		System.out.println(A[500000]);
	}
	
	private static void q_s(int[]A,int left,int right) {
		if(left>=right) {
			return;
		}
		int p=p(A,left,right);
		
		q_s(A,left,p-1);
		q_s(A,p+1,right);
	}
	
	private static int p(int[]A,int left,int right) {
		int pivot=A[left];
		
		int i=left+1;
		int j=right;
		
		while(i<=j) {
			while(i<=j && A[i]<=pivot) i++;
			while(i<=j && A[j]>=pivot) j--;
			if(i<j) {
				swap(A,i,j);
			}
		}
		
		swap(A,left,j);
		
		return j;
	}
	
	private static void swap(int[]A,int i,int j) {
		int tmp=A[i];
		A[i]=A[j];
		A[j]=tmp;
	}
}
