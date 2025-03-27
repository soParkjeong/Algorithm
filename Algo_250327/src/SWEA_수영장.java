import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_수영장 {
    static int[]plan;
    static int day;
    static int month;
    static int month3;
    static int year;
    static int minCost;
    static int[] price;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine().trim());
        
        for(int tc=1;tc<=T;tc++) {
            String[]str=br.readLine().trim().split(" ");
            price=new int[4];
            for(int i=0;i<4;i++) {
                price[i]=Integer.parseInt(str[i]);
            }

            String[] st=br.readLine().trim().split(" ");
            plan=new int[12];
            for(int i=0;i<12;i++) {
                plan[i]=Integer.parseInt(st[i]);
            }//이용 계획 배열 완성 
            
            minCost=Integer.MAX_VALUE;
            dfs(0,0);
            System.out.println("#"+tc+" "+minCost);
        }
    }
    
    static void dfs(int month,int cost) {//dfs(이용 시작 달,누적 이용료) 
        //달 별 이용권 체크-> 12월까지 다 체크하면 종료 
        if(month>=12) {
            minCost=Math.min(minCost,cost);
            return;
        }
        
        if(cost>=minCost) return;//지금까지의 cost가 minCost보다 크면 return(더 이상 탐색 가치 없음)

        dfs(month+1,cost+(plan[month]*price[0]));//해당 달 내 이용일 수 * 1일 이용권 가격 
        
        dfs(month+1,cost+price[1]);//달 개수 * 1달 이용권 가격
        
        dfs(month+3,cost+price[2]);//3달 개수 * 3달 이용권 가격 
        
        minCost=Math.min(minCost, cost+price[3]);//1년 * 1년 이용권 가격 
    }
}
