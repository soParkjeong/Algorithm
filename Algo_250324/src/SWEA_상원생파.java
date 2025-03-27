import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
public class SWEA_상원생파 {
    static int cnt;
    static Set<Integer> set;
    static List<Integer>[]friends;
    static boolean[] visited;
    static int N;
    static int M;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine().trim());
        for(int tc=1;tc<=T;tc++) {
            String[]NM=br.readLine().trim().split(" ");
            N=Integer.parseInt(NM[0]);
            M=Integer.parseInt(NM[1]);
             
            friends=new ArrayList[N+1];
            for(int i=0;i<N+1;i++) {
                friends[i]=new ArrayList<>();
            }
             
            visited=new boolean[N+1];
             
            for(int i=0;i<M;i++) {
                String[]ab=br.readLine().trim().split(" ");
                int a=Integer.parseInt(ab[0]);
                int b=Integer.parseInt(ab[1]);
                 
                friends[a].add(b);
                friends[b].add(a);
            }
             
             
            set=new HashSet<Integer>();
 
            visited[1]=true;
            dfs(1,0);
            System.out.println("#"+tc+" "+set.size());
        }
    }
        static void dfs(int node,int depth) {
            if(depth==2) {
                return;
            }
             
            for(int i=0;i<friends[node].size();i++) {
                if(!visited[friends[node].get(i)]) {
                    visited[friends[node].get(i)]=true;
                    set.add(friends[node].get(i));
                }
                    dfs(friends[node].get(i),depth+1);
            }   
        }
}