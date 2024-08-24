import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 작업을 요청 시점 순으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int currentTime = 0;
        int totalResponseTime = 0;
        int jobIndex = 0;
        int jobCount = jobs.length;

        while (jobIndex < jobCount || !pq.isEmpty()) {
            // 현재 시점에 처리할 수 있는 작업들을 우선순위 큐에 넣음
            while (jobIndex < jobCount && jobs[jobIndex][0] <= currentTime) {
                pq.add(jobs[jobIndex]);
                jobIndex++;
            }
            
            // 처리 가능한 작업이 있는 경우
            if (!pq.isEmpty()) {
                int[] currentJob = pq.poll();
                currentTime += currentJob[1];
                totalResponseTime += currentTime - currentJob[0];
            } else {
                // 현재 시점에서 처리할 작업이 없다면 시간을 다음 작업의 요청 시점으로 이동
                currentTime = jobs[jobIndex][0];
            }
        }
        
        // 평균 응답 시간 계산
        return totalResponseTime / jobCount;
    }
}
