import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int a=0;a<n-i;a++){
                System.out.print(" ");
            }
            for(int b=0;b<2*i-1;b++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n+1;i<=2*n-1;i++){
            for(int a=0;a<i-n;a++){
                System.out.print(" ");
            }
            for(int b=0;b<4*n-2*i-1;b++){
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
}