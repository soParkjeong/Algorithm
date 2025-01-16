import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int cnt1=1;
        int cnt2=n;
        for(int i=1;i<=n*2;i++){
            if(i%2==1){
                for(int a=0;a<cnt1;a++){
                    System.out.print("* ");
                }
                cnt1++;
            }
            else{
                for(int b=0;b<cnt2;b++){
                    System.out.print("* ");
                }
                cnt2--;
            }
            System.out.println();
        }
    
    }
}