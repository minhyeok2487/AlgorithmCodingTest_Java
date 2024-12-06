import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 각 기능별 완료까지 필요한 일수 계산
        int[] daysLeft = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        // 배포 기능 수 계산
        List<Integer> deployList = new ArrayList<>();
        int maxDay = daysLeft[0];
        int count = 1;

        for (int i = 1; i < daysLeft.length; i++) {
            if (daysLeft[i] <= maxDay) {
                // 이전 기능과 함께 배포 가능
                count++;
            } else {
                // 새로운 배포 주기 시작
                deployList.add(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }

        // 마지막 배포 기능 수 추가
        deployList.add(count);

        // List를 배열로 변환
        return deployList.stream().mapToInt(Integer::intValue).toArray();
    }   
}