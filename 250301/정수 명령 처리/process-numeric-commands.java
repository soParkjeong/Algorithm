import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<n;i++){
            String[] order=new String[2];
            if(order[0].equals("push")){
                stack.push(order[1]);
            }else if(order[0].equals("size")){
                System.out.println(stack.size());
            }else if(order[0].equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(order[0].equals("pop")){
                System.out.println(stack.pop());
            }else{
                System.out.println(stack.peek());
            }
        }
    }
}