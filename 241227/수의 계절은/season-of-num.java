import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        String result="";

        if((m>=1)&&(m<=2)){
            result="Winter";
        }
        else if(m<=5){
            result="Spring";
        }
        else if(m<=8){
            result="Summer";
        }
        else if(m<=11){
            result="Fall";
        }
        else{
            result="Winter";
        }
        System.out.print(result);
    }
}