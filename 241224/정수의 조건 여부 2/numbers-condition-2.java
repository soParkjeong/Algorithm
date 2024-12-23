import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        String result="";

        if(a==5){
            result="A";
        }
        if(a%2==0){
            result="B";
        }
        System.out.print(result);
    }
}