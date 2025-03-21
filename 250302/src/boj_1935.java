import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class boj_1935 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		char[] arr=sc.next().trim().toCharArray();
		Stack<Double>stack=new Stack<>();
		Map<Character, Double> values=new HashMap<>();
		
		
		for (int i = 0; i < N; i++) {
            values.put((char) ('A' + i), sc.nextDouble());  
        }
		
		
		for(char ch:arr) {
			if(ch>='A'&&ch<='Z') {
				stack.push(values.get(ch));
			}else {
				if(stack.size()>=2) {
					double K2=stack.pop();
					double K1=stack.pop();
					
					switch(ch) {
					case '+':stack.push(K1+K2);
					break;
					case '-':stack.push(K1-K2);
					break;
					case '*':stack.push(K1*K2);
					break;
					case '/':stack.push(K1/K2);
					break;
					}
				}
			}
		}
		if(stack.size()==1) {
			double result=stack.pop();
			System.out.printf("%.2f",result);
		}
	}
}
