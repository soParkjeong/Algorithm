import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int Am=sc.nextInt();
        int Ae=sc.nextInt();
        int Bm=sc.nextInt();
        int Be=sc.nextInt();

        System.out.print((Am>Bm)&&(Ae>Be)?1:0);
    }
}