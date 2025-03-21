
public class Stack04_함수호출 {
	public static void main(String[] args) {
		System.out.println("메실");
		int a=10;
		func1();
		System.out.println("메종");
	}
	
	static void func1() {
		System.out.println("함 1실");
		//~~작업 
		func2();
		System.out.println("함 1종");
	}
	static void func2() {
		System.out.println("함 2실");
		System.out.println("함 2종");
	}
}
