import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String c=sc.next();
        int n=sc.nextInt();
        if(c.equals("A")){
            for(int i=1;i<=n;i++){
                System.out.print(i+" ");
            }
        }
        else if(c.equals("D")){
            for(int a=n;a>=1;a--){
                System.out.print(a+" ");
            }
        }
    }
}