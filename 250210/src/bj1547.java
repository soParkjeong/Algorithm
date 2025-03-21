import java.util.Scanner;

public class bj1547 {
	 public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);

	  int n=sc.nextInt();
	  int[] arr= {1,2,3};
	  int tmp=0;

	  for(int i=0;i<n;i++) {
	      int a=sc.nextInt();
	      int b=sc.nextInt();

	      tmp=arr[a-1];
	      arr[a-1]=arr[b-1];
	      arr[b-1]=tmp;
	    }
	    
	  for(int i=0;i<3;i++) {//arr 배열의 길이는 3이므로 i=1;i<=3;i++하는 건 안됨 
		  if(arr[i]==1) {
	    	  System.out.println(i+1);//컵이 담겨있는 배열은 1~3까지라고 지정했으므로->여기서 i+1을 해야 함 
		  }
	  	}
	 }
}
