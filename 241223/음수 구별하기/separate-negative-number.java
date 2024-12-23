import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();

        if(a<0){
            System.out.println(a);
            System.out.print("minus");
        }
        else{
            System.out.print(a);
        }
    }
}