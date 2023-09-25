class Solution {
    public String solution(String my_string) {
        char[] stringArray = my_string.toCharArray();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        int count = 0;
        char[] result = new char[my_string.length()];

        for (int i = 0; i < my_string.length(); i++) {
            boolean isVowel = false;
            for (int k = 0; k < 5; k++) {
                if (stringArray[i] == vowels[k]) {
                    isVowel = true;
                    break;
                }
            }

            if (!isVowel) {
                result[count++] = stringArray[i];
            }
        }

        return new String(result, 0, count);
    }
}