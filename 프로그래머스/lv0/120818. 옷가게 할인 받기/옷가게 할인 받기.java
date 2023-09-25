class Solution {
    public int solution(int price) {
        int result=0;
        
        if(price>=100000&&price<300000){
            result=(int)price*95/100;
        }
        else if(price>=300000&&price<500000){
            result=(int)price*90/100;
        }
        else if(price>=500000){
            result=(int)price*80/100;
        }
        else{
            result=price;
        }
        return result;
    }
}