import java.util.Stack;
//여러가지 괄호를 고민해야 한다면...
//코드는 많이 복잡해질 수도 있다!
//map, switch, 배열 활용 가능

public class Stack_괄호검사 {
	//소괄호로만 구성되어 있다고 가정!
	public static void main(String[] args) {
		String str="()()()(()((())))";
		
		//괄호 검사
		//1. 괄호의 개수는 동일해야 함(여는 괄호/닫는 괄호)
		//2. 여는 괄호는 닫는 괄호보다 먼저 나와야 함
		//3. 괄호는 포함관계여야 함
		
		Stack<Character> stack=new Stack<>();
		boolean isOk=true;//어떤 값으로 초기화 할지는 목적을 잘 생각해볼 것!
		for(int i=0;i<str.length();i++) {
			//1. 여는 괄호라면 무조건 넣기 (,{,[,< 등등
			if(str.charAt(i)=='(') {
				stack.push(str.charAt(i));
			}
			//2. 닫는 괄호라면 고민 포인트
			else {
				//2-1. 스택이 공백이라면
				if(stack.isEmpty()) {
					isOk=false;
					break;
				}else {
					char c=stack.pop();//검사
				}
			}
		}//괄호검사 끝
		//정답 출력!
		if(isOk && stack.isEmpty()) {
			System.out.println("정답");
		}else {
			System.out.println("거짓");
		}
	}
}

