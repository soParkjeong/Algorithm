import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String result="";
        for(int i=n;i<=100;i++){
            if(i>=90){
                result="A";
            }
            else if(i>=80){
                result="B";
            }
            else if(i>=70){
                result="C";
            }
            else if(i>=60){
                result="D";
            }
            else{
                result="F";
            }
            System.out.print(result+" ");
        }
        
    }
}