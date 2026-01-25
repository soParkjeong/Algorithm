import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        //인접리스트로 그래프화
        //간선 하나씩 끊어보고 bfs로 연결된 송전탑 개수(k) 세기
        //반대 송전탑 개수는 n-k개
        //두 값의 차이가 적은 걸로 갱신
        List<Integer>[]graph=new ArrayList[n+1];//송전탑 1부터 시작하니까
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int[] w:wires){
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }
        
        int minDiff=Integer.MAX_VALUE;
        
        for(int[]cut: wires){
            int cutU=cut[0];
            int cutV=cut[1];
        
        int size=bfs(graph,n,cutU,cutU,cutV);
        
        int diff=Math.abs(size-(n-size));
        minDiff=Math.min(diff,minDiff);
        }
    
        return minDiff;
    }

    private int bfs(List<Integer>[]graph,int n,int start,int cutU,int cutV){
        boolean[] visited=new boolean[n+1];
        Queue<Integer>q=new ArrayDeque<>();

        visited[start]=true;
        q.add(start);

        int cnt=1;
        
        while(!q.isEmpty()){
            int cur=q.poll();

            for(int next:graph[cur]){
                //끊은 전선 패스
                if((cur==cutU && next==cutV)||(cur==cutV && next==cutU)) continue;

                if(!visited[next]){
                    visited[next]=true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}