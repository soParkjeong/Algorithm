import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 정점의 개수 N, 간선의 개수 M, 탐색을 시작할 정점의 번호 V를 입력 받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 그래프를 나타내기 위한 인접 리스트 생성
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력 받아서 그래프 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start); // 양방향 간선이므로 반대 방향도 추가
        }

        // 그래프의 각 리스트를 정렬하여 정점 번호가 작은 순서대로 탐색하도록 함
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 수행
        boolean[] visitedDFS = new boolean[N + 1];
        dfs(graph, V, visitedDFS, sb);
        sb.append('\n');

        // BFS 수행
        boolean[] visitedBFS = new boolean[N + 1];
        bfs(graph, V, visitedBFS, sb);
        sb.append('\n');

        System.out.println(sb);
    }

    // DFS 구현
    private static void dfs(ArrayList<Integer>[] graph, int v, boolean[] visited, StringBuilder sb) {
        visited[v] = true;
        sb.append(v).append(' '); // 정점을 StringBuilder에 추가
        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(graph, next, visited, sb);
            }
        }
    }

    // BFS 구현
    private static void bfs(ArrayList<Integer>[] graph, int start, boolean[] visited, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            sb.append(v).append(' '); // 정점을 StringBuilder에 추가
            for (int next : graph[v]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}