class Solution {
    public int solution(int[] num_list) {
        int multiple=1;
        int sum=0;
        int sumPow=0;
        int result=0;
        
        for(int i=0;i<num_list.length;i++){
            multiple*=num_list[i];
            sum+=num_list[i];
            sumPow=(int)Math.pow(sum,2);
        }
        if(multiple<sumPow){
            result=1;
        }
            else if(multiple>sumPow){
                result=0;
            }
            else{
            }
        
        return result;
        }
    }
