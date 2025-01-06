import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
            System.out.println();
        }
        for(int a=0;a<=n-2;a++){
            for(int b=0;b<=n-(a+2);b++){
                System.out.print("*");
            }
            System.out.println();
            System.out.println();
        }
    }
}