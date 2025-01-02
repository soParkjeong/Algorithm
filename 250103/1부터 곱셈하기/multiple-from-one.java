import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int result=1;
        int i=1;

        for(i=1;i<=10;i++){
            result*=i;
            if(result>=n){
                break;
            }
        }
        System.out.print(i);
    }
}