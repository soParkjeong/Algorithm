import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] st_1=new int[]{1,2,3,4,5};
        int[] st_2=new int[]{2,1,2,3,2,4,2,5};
        int[] st_3 = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int[]score=new int[3];
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==st_1[i%st_1.length]) score[0]++;
            if(answers[i]==st_2[i%st_2.length]) score[1]++;
            if(answers[i]==st_3[i%st_3.length]) score[2]++;
        }
        
        int max=Math.max(score[0],Math.max(score[1],score[2]));
        
        List<Integer>result=new ArrayList<>();
        for(int i=0;i<3;i++){
            if(score[i]==max){
                result.add(i+1);//1-based
            }
        }
        
        int[]answer=new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        return answer;
    }
}