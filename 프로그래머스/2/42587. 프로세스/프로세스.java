import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            deque.offerLast(new int[]{priorities[i], i});
        }
        
        int printOrder = 0; // 몇 번째로 출력되는지 카운트
        
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            boolean hasHigherPriority = false;
            
            // 현재 큐에 남아있는 프로세스 중 더 높은 우선순위가 있는지 확인
            for (int[] item : deque) {
                if (item[0] > current[0]) {
                    hasHigherPriority = true;
                    break;
                }
            }
            
            if (hasHigherPriority) {
                // 더 높은 우선순위가 있다면 현재 프로세스를 다시 큐의 뒤로 이동
                deque.offerLast(current);
            } else {
                // 그렇지 않다면 프로세스를 실행
                printOrder++;
                if (current[1] == location) {
                    return printOrder;
                }
            }
        }
    
        return -1;
    }
}