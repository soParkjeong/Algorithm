class Solution {
    public int solution(int n, int k) {
     int yakitoriPricePerPerson = 12000;
        
        // 음료수 가격
        int drinkPrice = 2000;
        
        // 양꼬치 인분에 따른 총 양꼬치 가격 계산
        int totalYakitoriPrice = n * yakitoriPricePerPerson;
        
        // 서비스로 주어지는 음료수 개수에 따른 총 음료수 가격 계산
        int totalDrinkPrice = (k-(n / 10))*2000 ;
        
        // 총 지불해야 하는 금액 계산
        int totalPrice = totalYakitoriPrice + totalDrinkPrice;
        
        return totalPrice;
    }
}