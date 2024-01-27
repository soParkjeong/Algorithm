import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            Queue<Document> queue = new LinkedList<>();

            String[] priorities = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(priorities[i]);
                queue.offer(new Document(i, priority));
            }

            int count = 0;

            while (!queue.isEmpty()) {
                Document currentDoc = queue.poll();
                boolean canPrint = true;

                for (Document doc : queue) {
                    if (doc.priority > currentDoc.priority) {
                        canPrint = false;
                        break;
                    }
                }

                if (canPrint) {
                    count++;
                    if (currentDoc.index == M) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    queue.offer(currentDoc);
                }
            }
        }

        br.close();
    }

    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}