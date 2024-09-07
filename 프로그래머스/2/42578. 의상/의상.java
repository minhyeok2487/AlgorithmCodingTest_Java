import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        // key - 의상의 종류, value - 의상의 이름 갯수
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i< clothes.length; i++) {
            int value = map.getOrDefault(clothes[i][1], 0);
            map.put(clothes[i][1], ++value);
        }
        
    
        if (map.keySet().size() > 1) {
            int answer = 1;
            for (String key : map.keySet()) {
                answer *= (map.get(key) + 1);
            }
            return answer - 1;
        } else {
            return clothes.length;
        }
    }
}