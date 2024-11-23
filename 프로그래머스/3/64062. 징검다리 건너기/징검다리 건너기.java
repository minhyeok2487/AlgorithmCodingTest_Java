import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canCross(stones, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
    
    private boolean canCross(int[] stones, int k, int people) {
        int count = 0;
        
        // 각 돌을 건널 때 people만큼의 인원이 지나갈 수 있는지 확인
        for (int stone : stones) {
            
            // 건널 수 없으면 카운트 증가
            if (stone - people < 0) {
                count++;
            } else {
                count = 0;
            }
            
            // 연속된 건널 수 없는 돌의 갯수가 k(길이) 이상이면 false
            if (count >= k) {
                return false;
            }
        }
        
        return true;
    }
}