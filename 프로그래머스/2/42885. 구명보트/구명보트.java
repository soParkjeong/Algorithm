import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        //일단 정렬
        //젤 앞에꺼랑 뒤에서 몇번째꺼랑 더해졌을 때 limit에 최대한 가까울지
        //그 다음꺼랑 뒤에서 몇번째꺼랑 더해졌을 때 ... 반복
        Arrays.sort(people);
        int i=0;
        int sum=0;
        int idx=people.length-1;//끝 포인터
        int cnt=0;

        while(i<=idx){
            sum=people[i]+people[idx];
            if(sum<=limit){
                i++;
            }
            idx--;
            cnt++;
            sum=0;
        }
        
        return cnt;
    }
}