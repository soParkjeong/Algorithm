public class Main {
    public static void main(String[] args) {
        int a=5;
        int b=6;
        int c=7;
        int temp1=a;
        int temp2=b;
        a=c;
        b=temp1;
        c=temp2;
        System.out.printf("%d\n%d\n%d",a,b,c);
    }
}