import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        //그래프 연결
        List<Integer>[]graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int[]e: edge){
            int a=e[0];
            int b=e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int[] dist=new int[n+1];
        Arrays.fill(dist,-1);
        dist[1]=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(1);//시작점 넣기
        
        while(!q.isEmpty()){
            int cur=q.poll();
            
            for(int next:graph[cur]){
                if(dist[next]!=-1){
                    continue;
                }
                dist[next]=dist[cur]+1;
                q.add(next);
            }
        }
        
        int max=0;
        for(int i=1;i<=n;i++){
            if(dist[i]>max){
                max=dist[i];
            }
        }
            
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(dist[i]==max){
                answer++;
            }
        }
        return answer;
        
    }
}