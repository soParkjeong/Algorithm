import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class bj_DFSBFS {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList[N + 1];//그래프 크기: 노드개수+1 
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();//각 노드마다 새로운 리스트 생성 
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }//양방향 그래프 완성 

        // 정점번호 작은 것부터 방문하기 위해 정렬 
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // BFS 
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println();
    }

    // DFS-> 재귀 사용 
    static void dfs(int node) {
        visited[node] = true; 
        System.out.print(node + " ");

        for (int n_node : graph[node]) {//매개변수로 넘어온 노드에 연결된 노드를 재귀적으로 방문 
            if (!visited[n_node]) {
                dfs(n_node);
            }
        }
    }

    // BFS-> 반복문, 큐 활용 
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int n_node : graph[node]) {
                if (!visited[n_node]) {
                    queue.offer(n_node);
                    visited[n_node] = true;
                }
            }
        }
    }
}
