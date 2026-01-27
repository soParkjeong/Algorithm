import java.util.*;

class Solution {
    //모든 섬이 서로 통행 가능하도록 한다?
    //모든 정점 연결, 최소 비용-> 프림 ㄱ    
    static class Edge {
        int to,cost;

        public Edge(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
    }
    
    public int solution(int n, int[][] costs) {

        List<Edge>[]graph=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        
        for(int []e: costs){
            int a=e[0];//from,to
            int b=e[1];//to,from
            int c=e[2];//cost
            graph[a].add(new Edge(b,c));
            graph[b].add(new Edge(a,c));
        }
        
        boolean[] visited=new boolean[n];
        PriorityQueue<Edge>pq=new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        
        pq.offer(new Edge(0,0));
        
        int total=0;
        int picked=0;

        while(!pq.isEmpty()){
            Edge cur=pq.poll();
            int now=cur.to;

            if(visited[now]) continue;
            visited[now]=true;

            total+=cur.cost;
            picked++;

            for(Edge next:graph[now]){
                if(!visited[next.to]){
                    pq.offer(next);
                }
            }
        }
        
        return total;
    }
}