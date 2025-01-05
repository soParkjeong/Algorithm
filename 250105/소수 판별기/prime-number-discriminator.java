import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String result="P";
        for(int i=2;i<n;i++){
            if((n%i==0)){
                result="C";
            }
        }
        System.out.print(result);


    }
}