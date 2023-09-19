class Solution {
    public int solution(int n) {
        int pizzaCount=0;
         if(n%7!=0){
             pizzaCount=(n/7)+1;
         }
         else{
             pizzaCount=n/7;
         }
        return pizzaCount;
         }
    }


