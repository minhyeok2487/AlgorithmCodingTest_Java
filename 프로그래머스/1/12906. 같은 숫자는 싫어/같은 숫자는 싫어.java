import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(arr[0]);
        
        for (int i : arr) {
            Integer check = queue.peekLast();
            if (check != i) {
                queue.addLast(i);
            }
        }
        int[] answer = new int[queue.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.pollFirst();
        }

        return answer;
    }
}