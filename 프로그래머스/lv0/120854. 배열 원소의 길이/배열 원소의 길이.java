class Solution {
    public int[] solution(String[] strlist) {
        int[]result=new int[strlist.length];
        int wordLength=0;
        int k=0;
        
        for(int i=0;i<=strlist.length-1;i++){
            String word=strlist[i];
            wordLength=word.length();
            result[k]=wordLength;
            k++;
            }
            
        return result;
        
        
    }
}