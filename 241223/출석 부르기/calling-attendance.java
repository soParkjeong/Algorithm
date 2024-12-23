import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String person;

        if(n==1){
            person="John";
        }
        else if(n==2){
            person="Tom";
        }
        else if(n==3){
            person="Paul";
        }
        else{
            person="Vacancy";
        }
        System.out.print(person);
    }
}