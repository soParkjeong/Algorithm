import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=1;
        int n=sc.nextInt();
        int cnt=0;
        while(true){
            a*=2;
            cnt++;
            if(a==n){
                break;
            }
            
        }
        System.out.print(cnt);

    }
}