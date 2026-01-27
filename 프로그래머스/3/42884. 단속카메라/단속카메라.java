import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        //모든 차량이 한 번은 단속용 카메라를 만나도록..
        //routes[i][0]은 i번째 차량이 고속도로에 진입한 지점
        //routes[i][1]은 i번째 차량이 고속도로에서 나간 지점
        //routes[i][1]기반으로 오름차순 정렬하고
        //routes[i][1] 카메라 설치
        //그 다음 구간 안에 카메라 위치 포함되면 pass, 안되면 또 설치->카메라 위치 갱신
        Arrays.sort(routes,(a,b)->Integer.compare(a[1],b[1]));
        
        int num=0;
        int camera=Integer.MIN_VALUE;//카메라 위치
        
        for(int[]r: routes){
            int start=r[0];
            int end=r[1];

        
            if(camera<start){//카메라가 도로를 포괄 못하면
                num++;
                camera=end;//뉴 경로 끝에 추가 설치->카메라 위치 갱신
            }
        }
        
        return num;
    }
}