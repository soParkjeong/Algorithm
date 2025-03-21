import java.util.Scanner;
import java.util.Stack;

public class Stack05_뒤로앞으로 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//스택 2개(한글 변수는 권장 X) 
		Stack<String> 뒤로=new Stack<>();
		Stack<String> 앞으로=new Stack<>();
		
		//학생 관리-> do while
		String page="구글";
		while(true) {
			System.out.println("1. 새로운 페이지 방문(주소입력,파비콘 클릭");
			System.out.println("2. 뒤로가기 클릭");
			System.out.println("3. 앞으로가기 클릭");
			System.out.println("0. 종료(1,2,3을 제외한 어떠한 입력도 가능)");
			
			int N=sc.nextInt();
			switch(N) {
			case 1: 
				//새로운 페이지 방문
				//1. 현재 페이지를 '뒤로' 스택에 넣기
				뒤로.push(page);
				//2. 새로운 페이지 입력받기
				page=sc.next();
				//3. '앞으로' 스택을 비워야 함(뒤로 가기를 했을 때, 원래 있던 페이지를 '앞으로' 스택에 넣기)
				//새로운 페이지로 이동 시, '앞으로' 스택을 비워야 함 
				//방법 1) while, for문을 이용해 '앞으로' 스택이 공백 상태가 될 때까지 pop 해주기 
				while(!앞으로.isEmpty()) {
					앞으로.pop();
				}
				//방법 2) 새로운 스택을 생성한다.
				//방법 3) clear() 메서드를 활용하여 비워버린다. 
				//4. 현재 페이지 출력(선택)
				System.out.println("현재 페이지: "+page);
				break;
			case 2: 
				//뒤로 가기 기능
				if(뒤로.isEmpty()) {
					System.out.println("뒤로 가기 불가능");
				}else { 
					//1. 현재 페이지를 '앞으로' 스택에 넣기
					앞으로.push(page);
					//2. 현재 페이지에는 '뒤로' 스택에 있는 값을 pop()해서 대입해주기 
					page=뒤로.pop();
					//3. 출력한다.
					System.out.println("현재 페이지: "+page);
				}
				break;
			case 3: 
				//앞으로 가기 기능
				if(앞으로.isEmpty()) {
					System.out.println("앞으로 가기 버튼 비활성화");
				}else {
					//1. 현재 페이지를 '뒤로' 스택에 넣기	
					뒤로.push(page);
					//2. 현재 페이지를 '앞으로' 스택에 있는 값을 pop()해서 대입해주기 
					page=앞으로.pop();
					//3. 출력한다.
					System.out.println("현재 페이지: "+page);
				}
				break;
			default:
				System.out.println("종료합니다.");
				return;
			}
			
		}
	}
}
