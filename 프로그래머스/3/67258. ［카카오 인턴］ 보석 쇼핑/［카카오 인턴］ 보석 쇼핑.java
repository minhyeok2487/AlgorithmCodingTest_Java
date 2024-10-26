import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> gemKinds = new HashSet<>(Arrays.asList(gems));
        int kindCount = gemKinds.size();
        
        // 현재 구간에 포함된 보석들의 개수를 저장하는 Map
        Map<String, Integer> gemCount = new HashMap<>();
        
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        
        while(true) {
            // 모든 종류의 보석을 포함할 때까지 end 포인터 이동
            if(gemCount.size() < kindCount && end < gems.length) {
                gemCount.put(gems[end], gemCount.getOrDefault(gems[end], 0) + 1);
                end++;
            }
            // 모든 종류의 보석을 포함하면 start 포인터 이동
            else if(gemCount.size() == kindCount) {
                if(end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                }
                
                gemCount.put(gems[start], gemCount.get(gems[start]) - 1);
                if(gemCount.get(gems[start]) == 0) {
                    gemCount.remove(gems[start]);
                }
                start++;
            }
            // 더 이상 진행할 수 없는 경우
            else {
                break;
            }
        }
        
        answer[0] = minStart + 1;
        answer[1] = minStart + minLength;
        
        return answer;
    }
}