import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int result=0;

        if((a<=b)&&(a<=c)){
            result=a;
        }
        else if((a>=b)&&(b>=c)){
            result=c;
        }
        else{
            result=b;
        }
        System.out.print(result);
        
    }
}