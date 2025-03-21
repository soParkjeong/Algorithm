import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class SWEA_사칙연산 {
	static String[][] tree;
	static Stack<String> stack=new Stack<>();
	static Stack<Double> numStack=new Stack<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 for (int t = 1; t <= 10; t++) {
	            int N = Integer.parseInt(br.readLine());
	            tree = new String[N + 1][3]; // [노드 번호][값, 왼쪽 자식, 오른쪽 자식]

	            for (int i = 0; i < N; i++) {
	                String[] input = br.readLine().split(" ");
	                int idx = Integer.parseInt(input[0]); // 현재 노드 번호
	                tree[idx][0] = input[1]; // 값 (숫자 또는 연산자)

	                if (input.length > 2) { // 연산자일 경우 자식 정보 저장
	                    tree[idx][1] = input[2]; // 왼쪽 자식
	                    tree[idx][2] = input[3]; // 오른쪽 자식
	                }
	            }
			
	        postorder(1);
			double result=calculate();

			System.out.println("#"+(t+1)+" "+(int)result);
		
		}
	}
		
	//후위 순회(LRV)
	static void postorder(int v) {
		if(tree[v][0]==null) return;//트리 인덱스가 배열 범위를 벗어나면 종료
		
		if(tree[v][1]!=null) {
			postorder(Integer.parseInt(tree[v][1]));//왼쪽 자식 방문 
		}
		if(tree[v][2]!=null) {
			postorder(Integer.parseInt(tree[v][2]));//오른쪽 자식 방문 
		}
		stack.add(tree[v][0]); 
	}
	
	static double calculate() {
		while(!stack.isEmpty()) {
			String token=stack.remove(0);
			
			if(isNumber(token)) {//숫자면 스택에 저장 
				numStack.push(Double.parseDouble(token));
			}else {
				double b=numStack.pop();
				double a=numStack.pop();
				double result=0;
				
				switch(token.charAt(0)) {
					case '+': result = a + b; break;
					case '-': result = a - b; break;
					case '*': result = a * b; break;
					case '/': result = a / b; break;
				}
				numStack.push(result);
			}
		}
		return numStack.pop();
	}
	
	static boolean isNumber(String s) {
	    try {
	        Integer.parseInt(s); // 정수 변환 시도
	        return true; // 변환 성공하면 숫자
	    } catch (NumberFormatException e) {
	        return false; // 변환 실패하면 숫자가 아님
	    }
	}
}

