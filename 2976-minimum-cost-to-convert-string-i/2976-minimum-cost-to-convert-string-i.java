import java.util.*;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
       final long max=Integer.MAX_VALUE/4;
       long[][]dist=new long[26][26];//알파벳만 노드니까 플루이드 워셜 안터짐

       //dist 초기화
       for(int i=0;i<26;i++){
        Arrays.fill(dist[i],max);
        dist[i][i]=0;
       }

       //직접 변환 간선(여러 개 있을 수 있으니 최소 비용만)
       for(int i=0;i<original.length;i++){
        int u=original[i]-'a';
        int v=changed[i]-'a';
        dist[u][v]=Math.min(dist[u][v],(long)cost[i]);
       }

       //플로이드 워셜: 모든 문자쌍 최단 변환 비용
       for(int k=0;k<26;k++){
        for(int i=0;i<26;i++){
            if(dist[i][k]==max) continue;
            for(int j=0;j<26;j++){
                if(dist[k][j]==max) continue;
                long nd=dist[i][k]+dist[k][j];
                if(nd<dist[i][j]) dist[i][j]=nd;
            }
         }
       }

       //source->target 비용 합산
       long ans=0;
       for(int i=0;i<source.length();i++){
        int s=source.charAt(i)-'a';
        int t=target.charAt(i)-'a';
        long d=dist[s][t];
        if(d==max) return -1;
        ans+=d;
       }

       return ans;
    }
}
