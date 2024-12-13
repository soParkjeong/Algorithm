import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double n=sc.nextDouble();
        double result=30.48*n;
        System.out.printf("%.1f",result);
    }
}