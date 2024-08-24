import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // 배열의 모든 요소를 우선순위 큐에 추가
        for (int s : scoville) {
            minHeap.add(s);
        }
        
        int mixCount = 0;

        // 가장 작은 스코빌 지수가 K보다 작을 때만 반복
        while (minHeap.size() > 1 && minHeap.peek() < K) {
            int firstMin = minHeap.poll();  // 가장 작은 값
            int secondMin = minHeap.poll(); // 두 번째로 작은 값
            int newScoville = firstMin + (secondMin * 2); // 새로운 스코빌 지수 계산
            minHeap.add(newScoville);
            mixCount++;
        }
        
        // 반복이 끝난 후에도 가장 작은 스코빌 지수가 K보다 작으면 -1 반환
        return minHeap.peek() < K ? -1 : mixCount;
    }
}
