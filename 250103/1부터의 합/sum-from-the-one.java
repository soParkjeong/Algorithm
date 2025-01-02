import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        int i=0;

        for(i=1;i<=100;i++){
            sum+=i;
            if(sum>=n){
                break;
            }
        }
        System.out.print(i);
    }
}