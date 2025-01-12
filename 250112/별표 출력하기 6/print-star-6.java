import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
                for(int a=0;a<i-1;a++){
                    System.out.print("  ");
                }
                for(int b=0;b<=2*(n-i);b++){
                    System.out.print("* ");
                }
            System.out.println();
        }
       for(int i=n+1;i<=2*n-1;i++){
                for(int a=0;a<2*n-i-1;a++){
                    System.out.print("  ");
                }
                for(int b=0;b<=2*(i-n);b++){
                    System.out.print("* ");
                }
            System.out.println();
        }
    }
}
