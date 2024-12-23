import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String score="";

        if(a.equals("S")){
            score="Superior";
        }
        else if(a.equals("A")){
            score="Excellent";
        }
        else if(a.equals("B")){
            score="Good";
        }
        else if(a.equals("C")){
            score="Usually";
        }
        else if(a.equals("D")){
            score="Effort";
        }
        else{
            score="Failure";
        }
        System.out.print(score);
    }
}