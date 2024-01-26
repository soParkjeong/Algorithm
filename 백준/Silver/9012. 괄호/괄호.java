import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++) {
            Stack<Character> st = new Stack<>();
            String line = br.readLine();

            for (int a = 0; a < line.length(); a++) {
                char ch = line.charAt(a);

                if (ch == '(') {
                    st.push(ch);
                } else if (ch == ')') {
                    if (!st.isEmpty() && st.peek() == '(') {
                        st.pop();
                    } else {
                        st.push(ch);
                    }
                }
            }
            if (st.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        br.close();
    }
}