import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        
        for(int i=a;i<=b;){
            System.out.print(i+" ");
            if(i%2==0){
                i+=3;
            }
            else if(i%2==1){
                i*=2;
            }
            
        }

    }
}