public class Main {
    public static void main(String[] args) {
        int a=1;
        int b=2;
        int c=3;
        int result=a+b+c;
        a=b=c=result;
        System.out.printf("%d %d %d",a,b,c);
    }
}