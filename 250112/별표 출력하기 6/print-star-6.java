import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int a=0;a<i;a++){
                System.out.print("  ");
            }
            for(int a=0;a<(2*n-1)-(2*i);a++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=0;i<n-1;i++){
            for(int b=0;b<n-2-i;b++){
                System.out.print("  ");
            }
            for(int b=0;b<n+(2*i)-1;b++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}