import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cnt=0;
        int n=sc.nextInt();
        int a=n;

        for(int i=1;i<=a;i++){
            cnt++;
            n/=i;
            
            if(n<=1){
                break;
            }
        }
        System.out.print(cnt);
    }
}