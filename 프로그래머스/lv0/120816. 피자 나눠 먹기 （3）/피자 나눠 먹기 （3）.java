class Solution {
    public int solution(int slice, int n) {
        int pizzaCount=0;
       if(n%slice==0){
           pizzaCount=n/slice;
       }
        else{
            pizzaCount=(n/slice)+1;
        }
        return pizzaCount;
    }
}