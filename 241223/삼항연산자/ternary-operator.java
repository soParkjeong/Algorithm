import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();
        String score=(a==100)?"pass":"failure";
        System.out.print(score);
    }
}