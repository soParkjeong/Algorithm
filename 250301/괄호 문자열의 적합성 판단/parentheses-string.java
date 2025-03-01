import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character>stack=new Stack<>();
        String str = sc.next();
        char[] arr=str.toCharArray();
        // for(char ch:arr){
        //     stack.push(ch);
        // }//스택에 모두 넣어주기 
        boolean check=false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='('){
                stack.push(arr[i]);
            }else{
                if(stack.peek()=='('){
                    stack.pop();
                }else{
                    while(stack.peek()!='('){
                        stack.pop();
                    }
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            check=true;
        }

        if(check){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}