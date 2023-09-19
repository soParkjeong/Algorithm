class Solution {
    public int[] solution(int money) {
      int drinkCount=0;
      int exchangeMoney=0;
        
        drinkCount=money/5500;
        exchangeMoney=money-(5500*drinkCount);
        
        int[] result={drinkCount,exchangeMoney};
        return result;
    }
}