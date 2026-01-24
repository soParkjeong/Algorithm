class Solution {
    public int[] solution(int brown, int yellow) {
        //yellow의 약수 조합 중 (큰 것*2)+(작은 것*2)+4==brown 개수 중 
        //큰게 가로, 작은 게 세로-> [가로+2,세로+2]로 반환
        int b=0;//가로
        int[]answer=new int[2];
        
        for(int a=1;a<=yellow;a++){//세로
            int c=yellow%a;//나머지
            if(c==0){
                b=yellow/a;
                if((b*2)+(a*2)+4==brown){
                    answer[0]=b+2;
                    answer[1]=a+2;
                    return answer;
                }
            }
        }
        return answer;
    }
}