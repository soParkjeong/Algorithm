class Solution {
    public String solution(String my_string, int[] index_list) {
        char[]list = my_string.toCharArray();
        char[]result_list=new char[index_list.length];
        int k=0;
        
        for(int i=0;i<index_list.length;i++){
            k=index_list[i];
            result_list[i]=list[k];
        }
        return new String(result_list);
    }
}