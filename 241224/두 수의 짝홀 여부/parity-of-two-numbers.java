import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);

       int a=sc.nextInt();
       int b=sc.nextInt();

       String result1="";
       String result2="";

       if(a%2==0){
        result1="even";
       }
       else{
        result1="odd";
       }
       if(b%2==0){
        result2="even";
       }
       else{
        result2="odd";
       }

       System.out.println(result1);
       System.out.println(result2);
    }
}