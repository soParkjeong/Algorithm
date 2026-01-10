import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {

        HashMap<String, Integer> map = new HashMap<>();

        // 번호 저장
        for (String phone : phone_book) {
            map.put(phone, 1);
        }

        // 번호의 접두어가 저장된 번호들 내 존재하는지 확인
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if (map.containsKey(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }
}
