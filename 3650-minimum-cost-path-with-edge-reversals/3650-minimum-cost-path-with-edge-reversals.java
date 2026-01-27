import java.util.*;

class Solution {
    
    static class Edge{
        int to;
        int w;
        Edge(int to,int w){this.to=to; this.w=w;}
    }

    public int minCost(int n, int[][] edges) {
        //각 노드에 스위치가 하나 있고, 
        //각 노드별로 이 스위치는 최대 한 번만 사용할 수 있음
        //뒤집으면 원래 비용의 2배
        //주어진 단방향을 반대로 비용은 2배해서 add-> 양방향으로 그래프화
        //다익 돌리자
        ArrayList<Edge>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();

        for(int[] e: edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,2*w));
        }

        //다익스트라
        long[] dist=new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0]=0;

        PriorityQueue<long[]>pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.add(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] cur=pq.poll();
            int node=(int) cur[0];
            long cost=cur[1];

            if(cost>dist[node]) continue;
            if(node==n-1) return (int)cost;

            for(Edge e: graph[node]){
                int next=e.to;
                long nextCost=cost+e.w;

                if(nextCost<dist[next]){
                    dist[next]=nextCost;
                    pq.add(new long[]{next,nextCost});
                }
            }
        }
        return -1;
    }
}