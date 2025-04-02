import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWEA_젤다i {
    
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] dist;
//    static boolean[][] visited;
    static int n;
    
    static class node implements Comparable<node>{
        int now_x, now_y, cost;

        public node(int now_x, int now_y, int cost) {
            this.now_x = now_x;
            this.now_y = now_y;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o) {
        
            return Integer.compare(this.cost, o.cost);
            
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            n = Integer.parseInt(br.readLine());
            
            if (n == 0) {
                return;
            }
            
            map = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            } // map 입력완료
            
            dist = new int[n+1][n+1];
            
            for(int i=0;i<n;i++) {
            	Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            
//            visited = new boolean[n+1][n+1];
            
            Dijk(0,0);
            System.out.println(dist[n-1][n-1]);
        }
        
    }

    private static void Dijk(int start_x, int start_y) {
        PriorityQueue<node> pq = new PriorityQueue<>();
        
        dist[0][0] = map[0][0];
        pq.add(new node(start_x, start_y,map[0][0]));
        
        while (!pq.isEmpty()) {
            node curr = pq.poll();
            int now_x = curr.now_x;
            int now_y = curr.now_y;
            int cost = curr.cost;
            
            if (dist[now_x][now_y]<cost) {
                continue;
            }
            
//            visited[now_x][now_y] = true;
            
            for (int i = 0; i < 4; i++) {
                int nr = now_x + dr[i];
                int nc = now_y + dc[i];
                
                if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                	int newDist=dist[now_x][now_y]+map[nr][nc];
        			if(newDist<dist[nr][nc]){
        			    dist[nr][nc]=newDist;
        			    pq.add(new node(nr,nc,newDist));
        			}
                }
            }
        }
    }
}