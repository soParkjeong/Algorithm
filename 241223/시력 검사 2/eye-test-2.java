import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Double a=sc.nextDouble();
        String result;

        if(a>=1.0){
            result="High";
        }
        else if(a<1.0&&a>=0.5){
            result="Middle";
        }
        else{
            result="Low";
        }
        System.out.print(result);
    }
}