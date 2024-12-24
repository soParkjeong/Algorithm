import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        
        int result1=a>=b?1:0;
        int result2=a>b?1:0;
        int result3=b>=a?1:0;
        int result4=b>a?1:0;
        int result5=a==b?1:0;
        int result6=a!=b?1:0;
        
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
    }
}