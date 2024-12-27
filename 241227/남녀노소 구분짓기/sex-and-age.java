import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sex=sc.nextInt();
        int age=sc.nextInt();
        String result="";

        if(sex==0){
            if(age>=19){
                result="MAN";
            }
            else{
                result="BOY";
            }
        }
        else{
            if(age>=19){
                result="WOMAN";
            }
            else{
                result="GIRL";
            }
        }
        System.out.print(result);
    }
}