import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // Deque에 각 기능별 완료까지 필요한 일수 저장
        Deque<Integer> daysLeft = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            daysLeft.offer((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        // 배포 기능 수를 저장할 리스트
        List<Integer> deployList = new ArrayList<>();
        
        while (!daysLeft.isEmpty()) {
            // 첫 번째 기능의 완료 일수
            int maxDay = daysLeft.poll();
            int count = 1;
            
            // 다음 기능들 확인
            while (!daysLeft.isEmpty() && daysLeft.peek() <= maxDay) {
                daysLeft.poll();
                count++;
            }
            
            // 이번 배포에 포함된 기능 수 추가
            deployList.add(count);
        }
        
        // List를 배열로 변환
        return deployList.stream().mapToInt(Integer::intValue).toArray();
    }
}