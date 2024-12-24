import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();
        int b=sc.nextInt();
        int result1=0;
        int result2=0;

        if(a<b){
            result1=1;
        }
        else if(a==b){
            result2=1;
        }
        else if(a!=b){
            result2=0;
        } 
        else if(a>b){
            result1=0;
        }
        System.out.print(result1+" "+result2);
    }
}