import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("* ");
            for(int a=0;a<n;a++){
                System.out.print("* * ");
            }
            System.out.println();
            System.out.print("* ");
            System.out.print("  ");
            for(int b=0;b<n;b++){
            System.out.print("* ");
            System.out.print("  ");
            }
            System.out.println();
        }
        System.out.print("* ");
        for(int a=0;a<n;a++){
            System.out.print("* * ");
        }
    }
}