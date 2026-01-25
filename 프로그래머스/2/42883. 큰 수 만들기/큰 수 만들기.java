import java.util.*;

class Solution {
    public String solution(String number, int k) {
        //큐에 넣고
        //큐 젤 위에 있는 게 지금 넣는 거보다 작으면 걔를 poll
        //크면 큐에 추가
        //cnt가 k만큼 될 때까지 반복
        Deque<Character>q=new ArrayDeque<>();
        
        int cnt=0;
        
        for(int i=0;i<number.length();i++){
            char cur=number.charAt(i);
            
            while(cnt<k&&!q.isEmpty()&&q.peekLast()<cur){
                q.pollLast();
                cnt++;
            }
            q.addLast(cur);
        }
        
        while(cnt<k){
            q.pollLast();
            cnt++;
        }
        
        StringBuilder sb=new StringBuilder();
        for(char c:q) sb.append(c);
        return sb.toString();
    }
}