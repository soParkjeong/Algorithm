import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<n;i++){
            String str=sc.nextLine().trim();
            String[] order=str.split(" ");
            
            if(order[0].equals("push")){
                stack.push(Integer.parseInt(order[1]));
            }else if(order[0].equals("size")){
                System.out.println(stack.size());
            }else if(order[0].equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(order[0].equals("pop")){
                if(!stack.isEmpty()){
                    System.out.println(stack.pop());
                }
            }else if(order[0].equals("top")){
            	if(!stack.isEmpty()) {
            		System.out.println(stack.peek());
            	}
            }
        }
    }
}
