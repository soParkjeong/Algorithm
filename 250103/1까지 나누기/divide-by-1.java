import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cnt=1;
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            cnt++;
            n/=i;
            
            if((n/i)<=1){
                break;
            }
        }
        System.out.print(cnt);
    }
}