import java.util.Stack;

public class Stack01_API {
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<>();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
		//스택에 있는 모든 자료를 전부 다 출력하고 싶은 경우
		//pop()을 반복할거야!
		//방법 1: size 변수 저장 
		int size=stack.size();
		for(int i=0; i<size; i++) {
			System.out.println(stack.pop());
		}
		//이런식으로 stack.size()를 변수로 넣어주면 pop()되면서 stack.size()가 유동적으로 바뀌므로 위험할 수 있음
		
		//방법 2: stack.size()를 젤 처음 1번 사용하고 사용하지 않도록 for문 작성 
		for(int i=stack.size()-1; i>=0; i--) {
			System.out.println(stack.pop());
		}
		
		//방법 3: while문 사용 
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println(stack.isEmpty());
	}
}
