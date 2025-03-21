import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SWEA_철근 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		
		for(int tc=1;tc<=T;tc++) {
			Stack<Character>stack=new Stack<>();
			boolean isOk=true;//어떤 값으로 초기화할지는 목적을 잘 생각해볼 것!
			
			char[] arr=br.readLine().trim().toCharArray();
			List<Integer>list=new ArrayList<>();
			int cnt=0;
			
			for(int i=0;i<arr.length;i++) {
				if(arr[i]=='(') {
					stack.push(arr[i]);
				}else {//닫는 괄호이면,
					if(stack.isEmpty()) {
						isOk=false;
						break;
					}else {//스택이 비어있지 않되, 닫는 괄호이면,
						stack.pop();
						if(i>0 && arr[i-1]=='(') {//바로 직전 요소가 (이면 ->레이저니까 지금까지 쌓인 스택크기만큼 쪼개짐 
							cnt+=stack.size();
						}else {//레이저가 아닌 )면, 철근이 끝나는 것 
							cnt+=1;
						}
					}
				}
			}
			System.out.println("#"+(tc)+" "+cnt);
		}
	}
}
