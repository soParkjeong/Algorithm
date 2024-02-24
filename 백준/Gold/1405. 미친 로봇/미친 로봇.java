import java.util.Scanner;

public class Main {
    static int N;
    static double[] probabilities;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        probabilities = new double[4];
        visited = new boolean[30][30]; 

        for (int i = 0; i < 4; i++) {
            probabilities[i] = scanner.nextDouble() / 100.0;
        }

        System.out.println(backtrack(15, 15, 0)); 
    }

    static double backtrack(int x, int y, int depth) {
        if (visited[x][y]) return 0.0;
        if (depth == N) return 1.0; 

        visited[x][y] = true; 

        double result = 0.0;
       
        result += probabilities[0] * backtrack(x + 1, y, depth + 1);
        result += probabilities[1] * backtrack(x - 1, y, depth + 1);
        result += probabilities[2] * backtrack(x, y + 1, depth + 1);
        result += probabilities[3] * backtrack(x, y - 1, depth + 1);

        visited[x][y] = false; 
        return result;
    }
}
