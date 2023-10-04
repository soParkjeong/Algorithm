class Solution {
    public int[] solution(int[] num_list, int n) {
        int count=0;
        int k=0;
        int length=num_list.length;
        
        if(length%n==0){
            count=length/n;
        }
        else if(length%n!=0){
            count=(length/n)+1;
        }
        else{
            count=1;
        }
        
        int[] result=new int[count];
        
        for(int i=0;i<length;i++){
            if((i*n)<length){
            result[k]=num_list[i*n];
            k++;
        }
        }
        return result;
    }
}