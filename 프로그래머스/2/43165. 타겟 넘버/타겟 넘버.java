import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(numbers[0]);
        Q.offer(-numbers[0]);
        ArrayList<Integer> answers = new ArrayList<>();
        
        for(int i = 1; i < numbers.length; i++) {
            int len = Q.size();
            for (int j=0; j < len; j++) {
                int x = Q.poll();
                Q.offer(x + numbers[i]);
                Q.offer(x - numbers[i]);
            }
        }
        
        while(!Q.isEmpty()) {
            if(Q.poll() == target) {
                answer++;
            }
        }
        
        return answer;
    }
}