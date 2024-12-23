import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        String result;

        if(a<0){
            result="ice";
        }
        else if(a>=0&&a<100){
            result="water";
        }
        else{
            result="vapor";
        }

        System.out.print(result);
    }
}