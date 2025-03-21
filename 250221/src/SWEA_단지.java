import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.IOException;


public class SWEA_단지{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도의 크기 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 지도 입력 받기
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // BFS를 사용하여 각 단지의 집 수를 구하기
        List<Integer> counts = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                	int count=bfs(map,visited,i,j);
                    counts.add(count);
                }
            }
        }

        // 결과 출력
        Collections.sort(counts);
        System.out.println(counts.size());
        for (int count : counts) {
            System.out.println(count);
        }

        br.close();
    }

    // BFS로 각 단지의 집 수를 구하는 함수
    private static int bfs(int[][] map, boolean[][] visited, int startX, int startY) {
        int[] dx = {-1, 1, 0, 0}; // 상하좌우
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        int[] start=new int[2];
        start[0]=startX;
        start[1]=startY;
        queue.offer(start);//시작점 일단 저장 
        visited[startX][startY] = true;//방문 처리 
        int count = 0;//count 초기화 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            count++;//현 위치 저장해주고 count+1

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length
                        && map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return count;
    }
}