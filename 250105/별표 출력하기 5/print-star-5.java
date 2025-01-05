import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int k=0;k<n-i;k++){
                for(int j=0;j<n-i;j++){
                    System.out.print("*");
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }

}