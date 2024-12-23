import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String pur="";

        if(n>=3000){
            pur="book";
        }
        else if(n>=1000){
            pur="mask";
        }
        else if(n>=500){
            pur="pen";
        }
        else{
            pur="no";
        }
        System.out.print(pur);
    }
}