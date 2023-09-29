class Solution {
    public int[] solution(int[] num_list) {
        int[] result = new int[num_list.length+1];
        int k=num_list.length;
        
        for(int i=0;i<k;i++){
            if(num_list[k-1]>num_list[k-2]){
                result[i]=num_list[i];
                result[k]=(int)(num_list[k-1]-num_list[k-2]);
            }
            else{
                result[i]=num_list[i];
                result[k]=(int)(num_list[k-1]*2);
            }
        }
        return result;
    }
}