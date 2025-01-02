import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cnt=0;
        int sum=0;
        double mean=0;
        for(int i=0;i<10;i++){
            int a=sc.nextInt();
            if((a>=0)&&(a<=200)){
                sum+=a;
                cnt++;
            }
        }
        mean=(double)sum/cnt;
        System.out.printf("%d %.1f",sum,mean);
    }
}