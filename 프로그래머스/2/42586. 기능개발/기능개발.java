import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 각 기능이 배포되는 데 걸리는 시간을 저장할 큐
        Deque<Integer> deployDaysQueue = new ArrayDeque<>();
        
        // 각 기능에 대해 완료까지 걸리는 일수를 계산하여 큐에 추가
        for (int i = 0; i < progresses.length; i++) {
            // (100 - 현재 진행 상황)을 속도로 나눈 값으로 일수를 계산
            int daysToComplete = (100 - progresses[i]) / speeds[i];
            // 나머지가 있으면 하루 더 필요
            if ((100 - progresses[i]) % speeds[i] > 0) {
                daysToComplete++;
            }
            // 큐의 끝에 계산된 일수를 추가
            deployDaysQueue.offerLast(daysToComplete);
        }
        
        int maxDay = 0; // 현재 배포 기준이 되는 최대 일수
        List<Integer> releaseCountList = new ArrayList<>(); // 배포별 기능 수를 저장할 리스트
        
        // 큐가 비어있지 않은 동안 반복
        while (!deployDaysQueue.isEmpty()) {
            // 큐의 맨 앞에 있는 배포 일수를 가져옴
            int currentDay = deployDaysQueue.pollFirst();
            
            // 현재 일수가 최대 일수보다 크면 새로운 배포 그룹 시작
            if (currentDay > maxDay) {
                maxDay = currentDay; // 최대 일수를 갱신
                releaseCountList.add(1); // 새로운 배포 그룹을 시작하고 1로 초기화
            } else {
                // 기존 배포 그룹에 포함되는 경우, 마지막 배포 그룹의 기능 수를 증가시킴
                int lastIndex = releaseCountList.size() - 1;
                releaseCountList.set(lastIndex, releaseCountList.get(lastIndex) + 1);
            }
        }
        
        // 리스트를 int 배열로 변환하여 반환
        return releaseCountList.stream().mapToInt(Integer::intValue).toArray();
    }
}
