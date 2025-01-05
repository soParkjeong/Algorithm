import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int result=1;
        for(int i=0;i<5;i++){
            int n=sc.nextInt();
            if((n%3)!=0){
                result=0;
            }
        }
        System.out.print(result);
    }
}