import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cnt=0;
        int n=sc.nextInt();
        while(true){
            if(n%2==0){
                n=(n*3)+1;
                cnt++;
            }
            else{
                n=(n*2)+2;
                cnt++;
            }
            if(n>=1000){
                break;
            }
        }
        System.out.print(cnt);
    }
}