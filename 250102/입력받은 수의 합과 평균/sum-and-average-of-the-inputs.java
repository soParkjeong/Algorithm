import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        int cnt=0;
        double mean=0;

        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            sum+=a;
            cnt++;
        }
        mean=(double)sum/cnt;
        System.out.printf("%d %.1f",sum,mean);
    }
}