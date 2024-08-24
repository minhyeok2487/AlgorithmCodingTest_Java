import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int s : scoville) {
            minHeap.add(s);
        }
        
        while (minHeap.peek() < K) {
            if (minHeap.size() < 2) {
                return -1;
            }
            
            int min = minHeap.poll();
            int min2 = minHeap.poll();
            int mix = min + (min2 * 2);
            minHeap.add(mix);
            answer++;
        }
        return answer;
    }
}