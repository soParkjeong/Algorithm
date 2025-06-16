import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int[] arr = new int[1001];  // index는 0~1000까지만 쓴다고 가정

		int top=0;
		int topIdx=0;
		int maxIdx=0;
		int maxValue2=0;
		for (int i = 0; i < N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int index = Integer.parseInt(st.nextToken());
		    int value = Integer.parseInt(st.nextToken());
		    arr[index] = value;  // index에 value 저장
		    if(top<=value) {
		    	top=value;
		    	topIdx=index;
		    }
		    maxIdx=Math.max(maxIdx, index);
		}
	
		
//		System.out.println(top+" "+topIdx+" "+maxIdx+" "+maxValue2);
		
		for (int i=1;i<=topIdx;i++) {
		    if(arr[i]<=arr[i-1]) {
		    	arr[i]=arr[i-1];
		    }
		}
		
		for(int i=maxIdx;i>topIdx;i--) {
		    if(arr[i]>=arr[i-1]) {
		    	arr[i-1]=arr[i];
		    }
		}
		
		int sum=0;
		for(int i=0;i<=maxIdx;i++) {
			sum+=arr[i];
		}
		
		System.out.println(sum);
	}
}
