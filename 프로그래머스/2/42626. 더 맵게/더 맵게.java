import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) {
            pq.add(i);
        }
        
        while(!pq.isEmpty()) {
            int start = pq.poll();
            if (start >= K) {
                return answer;
            } else {
                if (pq.isEmpty()) {
                    return -1;
                } else {
                    int next = pq.poll();
                    pq.add(start + (next) * 2);
                    answer++;
                }
            }
        }
        return -1;
    }
}