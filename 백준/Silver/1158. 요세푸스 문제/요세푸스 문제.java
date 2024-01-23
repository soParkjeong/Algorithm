import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String command = s.nextLine();
        Queue<Integer> q = new LinkedList<>();
        String[] tokens = command.split(" ");

        int N = Integer.parseInt(String.valueOf(tokens[0]));
        int k = Integer.parseInt(String.valueOf(tokens[1]));

        int a = 1;


        for (int i = 0; i < N; i++) {
            q.offer(a);
            a++;
        }
System.out.print("<");
        while (!q.isEmpty()) {
            for (int i = 0; i < (k - 1); i++) {
                q.offer(q.poll());
            }
                System.out.print(q.poll());
            
            if (!q.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
        s.close();
    }
}