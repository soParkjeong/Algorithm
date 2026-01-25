import java.util.*;

class Solution {
    //depth가 5만큼 들어갈 수 있고,
    //word랑 동일한 때까지 센 수를 return
    //A->E->I->O->U 순서대로 확장 가능
    static final char[] dict={'A','E','I','O','U'};
    static int cnt;
    static int answer;
        
    public int solution(String word){
        cnt=0;
        answer=0;
        dfs("",word);
        return answer;
    }

    private void dfs(String cur, String target){
        if(!cur.isEmpty()){
            cnt++;
            if(cur.equals(target)){
                answer=cnt;
                return;
            }
        }

        if(cur.length()==5) return;

        for(char c:dict){
            if(answer!=0) return;
            dfs(cur+c,target);
        }
    }
}