import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double h=sc.nextDouble();
        double w=sc.nextDouble();

        double b=(10000*w)/(h*h);
        int B=(int)b;

        if(b>=25){
            System.out.printf("%d\n",B);
            System.out.print("Obesity");
        }
        else{
            System.out.printf("%d",B);
        }
    }
}