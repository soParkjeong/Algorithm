class Solution {
    public int solution(String str1, String str2) {
        char[]str1Array=str1.toCharArray();
        char[]str2Array=str2.toCharArray();
        
        int k=0;
      
           for(int i=0;i<str1Array.length;i++){
               if(str1Array[i]==str2Array[k]){
                   k++;
                   if(k==str2Array.length){
                       return 1;//str2가 str1안에 연속으로 존재함
                   }
                }else{
                   k=0;//다시 str2의 첫 문자부터 검사
               }
       }
        return 2;//str2가 str1 안에 연속으로 존재하지 않음
    }
}