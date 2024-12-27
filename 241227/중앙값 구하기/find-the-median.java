import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int result=0;

        if(a>b){
            if(b<c){
                if(a>c){
                    result=c;
                }
                else{
                    result=a;
                }
            }
            else{
                result=b;
            }
        }
        else{
            if(b<c){
                result=b;
            }
            else{
                if(a<c){
                    result=c;
                }
                else{
                    result=a;
                }
            }
        }
        System.out.print(result);
    }
}