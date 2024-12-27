import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a1=sc.next();
        int a=sc.nextInt();
        String b1=sc.next();
        int b=sc.nextInt();
        String c1=sc.next();
        int c=sc.nextInt();
        String result="";

        if(a1.equals("Y")&&(a>=37)){
            if((b1.equals("Y")&&(b>=37))||(c1.equals("Y")&&(c>=37))){
                result="E";
            }
            else{
                result="N";
            }
        }
        else{
            if((b1.equals("Y")&&(b>=37))&&(c1.equals("Y")&&(c>=37))){
                result="E";
            }
            else{
                result="N";
            }
        }
        System.out.print(result);
    
    }
}