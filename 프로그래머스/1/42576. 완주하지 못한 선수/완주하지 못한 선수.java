import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        // 참가자 인원 카운트
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        // 완주자 카운트 차감
        for (String finisher : completion) {
            map.put(finisher, map.get(finisher) - 1);
        }
        
        // 카운트가 0이 아닌 사람이 완주하지 못한 사람
        for (String player : map.keySet()) {
            if (map.get(player) != 0) {
                return player;
            }
        }
        
        return "";
    }
}