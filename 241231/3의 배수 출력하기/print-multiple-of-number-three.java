import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i=1;
        int n=sc.nextInt();
        while((i*3)<=n){
            System.out.print((i*3)+" ");
            i++;
        }
    }
}