class Solution {
    public String solution(String[] str_list, String ex) {
     StringBuilder finalResult=new StringBuilder();
        
        for(int i=0;i<str_list.length;i++){
        boolean result=str_list[i].contains(ex);
            if(result==false){
                finalResult.append(str_list[i]);
            }
            else{
            }
        }
        return finalResult.toString();
    }
}