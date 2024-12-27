import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int age1=sc.nextInt();
        String s1=sc.next();
        int age2=sc.nextInt();
        String s2=sc.next();

        if((age1>=19)&&(s1.equals("M"))||(age2>=19)&&(s2.equals("M"))){
            System.out.print(1);
        }
        else{
            System.out.print(0);
        }
    }
}