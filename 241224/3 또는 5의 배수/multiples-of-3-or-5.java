import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        String result1="";
        String result2="";

        if(a%3==0){
            result1="YES";
        }
        else{
            result1="NO";
        }
        if(a%5==0){
            result2="YES";
        }
        else{
            result2="NO";
        }
        System.out.print(result1+"\n"+result2);
    }
}