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
        boolean check=true;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='('){
                stack.push(arr[i]);
            }else{
                if(stack.isEmpty()){
                    check=false;
                    break;
                }//아직 닫는 괄호가 있는데 스택이 빈 경우는 잘못된 괄호 
                else{
                stack.pop();
                }
            }
        }
        if(check && stack.isEmpty()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}