import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 고유한 보석 종류를 추출
        Set<String> uniqueGems = new HashSet<>(Arrays.asList(gems)); 
        
        // 고유한 보석의 수
        int gemTypes = uniqueGems.size(); 
        
        // 초기화
        Map<String, Integer> gemCount = new HashMap<>();
        int start = 0, end = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = {0, gems.length - 1};

        while (end < gems.length) {
            // 현재 보석을 맵에 추가하고 end 포인터를 증가
            gemCount.put(gems[end], gemCount.getOrDefault(gems[end], 0) + 1);
            end++;
            
            // 윈도우가 모든 보석 종류를 포함하면 윈도우 축소 시도
            while (gemCount.size() == gemTypes) {
                if (end - start < minLength) {
                    minLength = end - start;
                    answer[0] = start + 1;  // 1-based 인덱스로 변환
                    answer[1] = end;  // end는 이미 1 증가된 상태이므로 그대로 사용
                }
                
                // start 포인터를 증가시켜 윈도우 축소
                gemCount.put(gems[start], gemCount.get(gems[start]) - 1);
                if (gemCount.get(gems[start]) == 0) {
                    gemCount.remove(gems[start]);
                }
                start++;
            }
        }
        
        return answer;
    }
}
