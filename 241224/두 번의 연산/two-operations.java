import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int result=0;

        if(a%2==1){
            result=a+3;
        }
        if(result%3==0){
            result/=3;
        }
        if(a%3==0){
            result=a/3;
        }
        System.out.print(result);
    }
}