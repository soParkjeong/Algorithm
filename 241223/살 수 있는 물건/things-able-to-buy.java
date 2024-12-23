import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String pur;

        if(n>=3000){
            pur="book";
        }
        else if(n<3000&&n>=1000){
            pur="mask";
        }
        else{
            pur="no";
        }
        System.out.print(pur);
    }
}