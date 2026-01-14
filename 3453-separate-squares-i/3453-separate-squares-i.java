import java.util.*;

class Solution {
    public double separateSquares(int[][] squares) {
        //수평선 아래의 사각형 넓이가 사각형 넓이 전체 합의 절반이면 됨
        //이분탐색 ㄱ
        double minY=Double.POSITIVE_INFINITY;
        double maxY=Double.NEGATIVE_INFINITY;
        double total=0.0;//사각형 전체 넓이 총합

        for(int[]s: squares){
            double y=s[1];
            double l=s[2];
            minY=Math.min(minY,y);
            maxY=Math.max(maxY,y+l);
            total+=l*l;
        }

        double half=total/2.0;
        double low=minY;
        double high=maxY;

        for (int i = 0; i < 80; i++) {
            double mid = (low + high) / 2.0;
            double below = belowArea(squares, mid);

            if (below >= half) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high; // 최소 y
    }

    private double belowArea(int[][]squares,double Y){
        double sum=0.0;
        for(int[]s : squares){
            double y=s[1];
            double l=s[2];

            double h=Y-y;
            if(h<0) h=0;
            if(h>l) h=l;

            sum+=l*h;
        }
        return sum;
    }
}