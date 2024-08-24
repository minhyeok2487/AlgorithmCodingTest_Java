import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        // Max Heap 생성
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 작업량을 Max Heap에 추가
        for (int work : works) {
            maxHeap.add(work);
        }

        // n번 동안 가장 큰 작업량을 1씩 줄임
        for (int i = 0; i < n; i++) {
            if (!maxHeap.isEmpty()) {
                int maxWork = maxHeap.poll();
                if (maxWork > 0) {
                    maxWork -= 1;
                    maxHeap.add(maxWork);
                }
            }
        }

        // 남아 있는 작업량의 제곱합 계산
        long answer = 0;
        while (!maxHeap.isEmpty()) {
            int remainingWork = maxHeap.poll();
            answer += (long) remainingWork * remainingWork;
        }
        
        return answer;
    }
}