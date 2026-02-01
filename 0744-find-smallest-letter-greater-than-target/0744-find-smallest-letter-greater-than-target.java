class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans='0';
        for(char let:letters){
            if(let>target){
                ans=let;
                break;
            }
        }
        if(ans=='0'){
            ans=letters[0];
        }
        return ans;
    }
}