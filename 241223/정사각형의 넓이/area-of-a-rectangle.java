import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n<5){
            System.out.println(n*n);
            System.out.println("tiny");
        }
        else{
            System.out.print(n*n);
        }
    }
}