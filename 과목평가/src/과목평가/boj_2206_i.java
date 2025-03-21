package 과목평가;

import java.io.*;
import java.util.*;

public class boj_2206_i {
    static int N, M, K;
    static int[][] arr;
    static int[] lx = {-1, 1, 0, 0}; // 룩의 이동 (상하좌우)
    static int[] ly = {0, 0, -1, 1};
    static int[] nx = {-2, -2, -1, -1, 1, 1, 2, 2}; // 나이트 이동
    static int[] ny = {-1, 1, -2, 2, -2, 2, -1, 1};

    static class Node {
        int lx, ly, nx, ny;

        Node(int lx, int ly, int nx, int ny) {
            this.lx = lx;
            this.ly = ly;
            this.nx = nx;
            this.ny = ny;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return lx == node.lx && ly == node.ly && nx == node.nx && ny == node.ny;
        }

        @Override
        public int hashCode() {
            return Objects.hash(lx, ly, nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim()); // 테스트케이스 개수

        for (int tc = 1; tc <= T; tc++) {
            String[] NMK = br.readLine().trim().split(" ");
            N = Integer.parseInt(NMK[0]);
            M = Integer.parseInt(NMK[1]);
            K = Integer.parseInt(NMK[2]);

            arr = new int[N][M];
            int l_x = 0, l_y = 0, n_x = 0, n_y = 0;

            for (int i = 0; i < N; i++) {
                String[] str = br.readLine().trim().split(" ");
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                    if (arr[i][j] == 1) { // 룩 위치 저장
                        l_x = i;
                        l_y = j;
                    }
                    if (arr[i][j] == 2) { // 나이트 위치 저장
                        n_x = i;
                        n_y = j;
                    }
                }
            }

            System.out.println(bfs(l_x, l_y, n_x, n_y));
        }
    }

    static int bfs(int l_x, int l_y, int n_x, int n_y) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M]; // 룩 & 나이트 위치 방문 확인
        queue.add(new Node(l_x, l_y, n_x, n_y));
        visited[l_x][l_y][n_x][n_y] = true;

        Set<Node> validCases = new HashSet<>();

        for (int move = 0; move < K; move++) {
            int size = queue.size();
            Set<Node> nextLevel = new HashSet<>(); // 다음 상태 저장 (중복 제거)

            while (size-- > 0) {
                Node node = queue.poll();

                // 룩 이동 (기물 만나면 중지)
                for (int d = 0; d < 4; d++) {
                    int new_lx = node.lx;
                    int new_ly = node.ly;

                    while (true) {
                        int next_x = new_lx + lx[d];
                        int next_y = new_ly + ly[d];

                        if (next_x < 0 || next_x >= N || next_y < 0 || next_y >= M || arr[next_x][next_y] != 0) break;

                        new_lx = next_x;
                        new_ly = next_y;

                        Node newState = new Node(new_lx, new_ly, node.nx, node.ny);
                        if (!visited[new_lx][new_ly][node.nx][node.ny]) {
                            visited[new_lx][new_ly][node.nx][node.ny] = true;
                            nextLevel.add(newState);
                        }
                    }
                }

                // 나이트 이동 (기물이 있는 칸은 도착 불가)
                for (int d = 0; d < 8; d++) {
                    int new_nx = node.nx + nx[d];
                    int new_ny = node.ny + ny[d];

                    if (new_nx < 0 || new_nx >= N || new_ny < 0 || new_ny >= M || arr[new_nx][new_ny] != 0) continue;

                    Node newState = new Node(node.lx, node.ly, new_nx, new_ny);
                    if (!visited[node.lx][node.ly][new_nx][new_ny]) {
                        visited[node.lx][node.ly][new_nx][new_ny] = true;
                        nextLevel.add(newState);
                    }
                }
            }

            queue.addAll(nextLevel);
        }

        while (!queue.isEmpty()) {
            validCases.add(queue.poll());
        }

        return validCases.size();
    }
}