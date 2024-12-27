import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int Am=sc.nextInt();
        int Ae=sc.nextInt();
        int Bm=sc.nextInt();
        int Be=sc.nextInt();
        String result="";

        if(Am>Bm){
            result="A";
        }
        else if(Am==Bm){
            if(Ae>Be){
                result="A";
            }
            else{
                result="B";
            }
        }
        else{
            result="B";
        }
        System.out.print(result);
    }
}