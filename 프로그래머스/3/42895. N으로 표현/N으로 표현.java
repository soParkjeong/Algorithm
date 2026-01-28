import java.util.*;

class Solution {
    public int solution(int N, int number) {
        //N과 +,-,/,*을 활용해서 number을 만들어야 함
        //N을 최소한으로 사용하는 횟수 반환
        //최솟값이 8보다 크면 -1 반환-> N 사용횟수가 최대 8이네
        //
        if(N==number) return 1;
        
        Set<Integer>[]dp=new HashSet[9];//어차피 N은 1~8번만 사용 가능
        for(int i=1;i<=8;i++){
            dp[i]=new HashSet<>();
        }
        
        for(int k=1;k<=8;k++){
            int connect=0;
            for(int i=0;i<k;i++){
                connect=connect*10+N;
            }
            dp[k].add(connect);
        
            for(int i=1;i<k;i++){
                int j=k-i;
                for(int a:dp[i]){
                    for(int b:dp[j]){
                        dp[k].add(a+b);
                        dp[k].add(a-b);
                        dp[k].add(a*b);
                        if(b!=0){
                            dp[k].add(a/b);
                        }
                    }
                }
            }
        
            if(dp[k].contains(number)) return k;
        }
        
        return -1;
    }
}