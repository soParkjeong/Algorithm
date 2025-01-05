import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            int x=sc.nextInt();
            int y=sc.nextInt();
            String n=sc.next();
            if(n.equals("C")){
                System.out.print(x*y);
                break;
            }
            else{
                System.out.println(x*y);
            }
        }
        
    }
}