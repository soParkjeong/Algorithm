import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int l=sc.nextInt();
        int money=0;

        if(m>=90){
            if(l>=95){
                money=100000;
            }
            else if(l>=90){
                money=50000;
            }
            else{
                money=0;
            }
        }
        else{
            money=0;
        }
        System.out.print(money);
    }
}