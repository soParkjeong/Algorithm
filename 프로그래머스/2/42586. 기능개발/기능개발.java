import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //작업별 걸리는 시간으로 전환해서 배열에 담기
        int n = progresses.length;
        int[] day = new int[n];

        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            int s = speeds[i];
            day[i] = (remain + s - 1) / s; //올림해야 함
        }
        
        int cnt=1;
        Deque<Integer>ans=new ArrayDeque<>();
        int max=day[0];//젤 처음
        
        for(int d=1;d<day.length;d++){
            if(day[d]<=max){//작거나 같을 때는 같이 배포
                cnt++;
            }else{//더 커져버리면 다음 날에 
                ans.offer(cnt);
                cnt=1;//다시 초기화
                max=day[d];
            }
        }
        ans.offer(cnt);
        
        int idx2=0;
        int[]result=new int[ans.size()];
        while(!ans.isEmpty()){
            result[idx2++]=ans.poll();
        }
        
        return result;
    }
}