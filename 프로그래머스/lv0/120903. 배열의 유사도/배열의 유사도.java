class Solution {
    public int solution(String[] s1, String[] s2) {
        int count=0;
       for(int i=0;i<s1.length;i++){
           for(int k=0;k<s2.length;k++){
               if(s1[i].equals(s2[k])){
                   count++;
               }
           }
       }
        return count;
    }
}