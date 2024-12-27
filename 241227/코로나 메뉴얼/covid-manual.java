import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String result="";
        String[] result_array = new String[3];
        int count=0;


        for(int i=0;i<3;i++){
            String a1=sc.next();
            int a=sc.nextInt();
            if(a1.equals("Y")&&(a>=37)){
                result="A";
            }
            else if(a1.equals("N")&&(a>=37)){
                result="B";
            }
            else if(a1.equals("Y")&&(a<37)){
                result="C";
            }
            else{
                result="D";
            }
            result_array[i]=result;
        }
        for(String tmp:result_array){
            if(tmp.equals("A")){
                count++;
            }
        }
        if(count>=2){
            result="E";
        }
        else{
            result="N";
        }
        System.out.print(result);
    }
}