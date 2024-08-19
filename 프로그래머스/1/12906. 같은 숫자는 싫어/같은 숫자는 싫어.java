import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i : arr) {
            if (deque.peekLast() == null) {
                deque.offer(i);
            } else {
                if (!deque.peekLast().equals(i)) {
                    deque.offer(i);
                }
            }            
        }
        
        // deque의 요소를 answer 배열로 변환
        int[] answer = new int[deque.size()];
        int index = 0;
        for (int num : deque) {
            answer[index++] = num;
        }
        
        return answer;
    }
}