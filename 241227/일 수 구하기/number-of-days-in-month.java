import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int result=0;

        if(n<8){
            if(n==2){
                result=28;
            }
            else{
                if(n%2==0){
                    result=30;
                }
                else{
                    result=31;
                }
            }
        }
        else{
            if(n%2==0){
                result=31;
            }
            else{
                result=30;
            }
        }
        System.out.print(result);
    }
}