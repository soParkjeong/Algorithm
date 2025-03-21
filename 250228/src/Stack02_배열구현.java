//클래스로 따로 빼서 만들어도 좋음!

import java.util.Arrays;

public class Stack02_배열구현 {
	//배열을 이용한 스택 구현!
	static String[] stack=new String[10];//배열을 이용한 스택 구현 시에는 배열의 size를 신중하게 생각하고 지정!
	//계산하기 싫으면 10만~100만 사이 정도 크기로 지정 
	static int top=-1;//가장 초기의 top은 -1 or null로 지정 
	//top이 -1이라는 건 stack이 공백이라는 뜻!
	
	public static void main(String[] args) {
		push("짜장면");
		push("짬뽕");
		push("탕수육");
		
		System.out.println(Arrays.toString(stack));
		System.out.println(peek());
	}
	
	//삽입(Push)
	static boolean push(String value) {
		if(isFull()) {
			System.out.println("가득차서 더 이상 들어오지 못함");
			return false;
		}
		top++;//top이 가리키는 위치를 높여줌
		stack[top]=value;
		//stack[++top]=value;도 가능-> top이 가리키는 위치를 높여주고 값 대입 
		//top을 -1로 시작했으니까 top을 0으로 초기화하고 시작하고 싶으면 stack[top++]로 해도 됨 
		return true;
	}
	
	 //삭제(Pop)
	static String pop() {
		if(isEmpty()) {
			System.out.println("현재 공백 상태임");
			return null;
		}
		return stack[top--];//top위치에 있던 요소를 반환하고 top인덱스 감소시켜주기 
	}
	
	//조회(Peek)
	static String peek() {
		if(isEmpty()) {
			System.out.println("현재 공백 상태임");
			return null;
		}
		return stack[top];//스택의 top 인덱스에 있는 것을 반환 
	}
	
	//공백(Empty)
	static boolean isEmpty() {
//		if(top==-1) {
//			return true;
//		}else {
//			return false;
//		}
		return top==-1;//한 줄로 대체됨(위 4줄이) //if문 안의 조건식은 조건문 형태(즉, true면 반환) 따라서 return문에 조건문을 작성하면 똑같은 결과가 나옴 
	}
	
	//포화(배열이라서 사용 가능)
	static boolean isFull() {
		return top==stack.length-1; //top이 stack.length-1이면(true면) 반환 

	}
}
