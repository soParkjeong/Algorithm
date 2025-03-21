import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_계산기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0;t<10;t++) {
			int N=Integer.parseInt(br.readLine());
			char[]arr=br.readLine().toCharArray();	
			
			Stack<Character>stack=new Stack<>();
			
			//후위표현식 결과-StringBuilder에 임시 저장 out
			StringBuilder out=new StringBuilder();
			
			for(int i=0;i<N;i++) {
				if(arr[i]=='(') {
					stack.push(arr[i]);
				}else if((arr[i]>=0)&&(arr[i]<=9)) {
					out.append(arr[i]);
				}else if((arr[i]=='*')||(arr[i]=='/')){
					if((!stack.isEmpty())&&(stack.peek()=='*')||(stack.peek()=='/')) {
						out.append(stack.pop());
					}
					stack.push(arr[i]);
				}else if((arr[i]=='+')||(arr[i]=='-')) {
					while((!stack.isEmpty())&&(stack.peek()!='(')) {//스택이 비거나 스택의 맨 위 값이 '('일 때까지 pop 
						out.append(stack.pop());
					}
					stack.push(arr[i]);//stack 맨 위가 '('거나 스택이 비면 현재 값 push
				}else if(arr[i]==')') {
					while(stack.peek()!='(') {
						out.append(stack.pop());
					}
					stack.pop();//'('버리
				}
				while(!stack.isEmpty()) {
					out.append(stack.pop());
				}
				System.out.println(out.toString());
			}
		}
	}
}
