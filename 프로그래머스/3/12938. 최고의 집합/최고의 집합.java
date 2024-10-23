import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        // 불가능한 경우 체크 (n개의 자연수로 s를 만들 수 없는 경우)
        if (n > s) {
            return new int[]{-1};
        }
        
        // 결과 배열 초기화
        int[] answer = new int[n];
        
        // 기본값 = s를 n으로 나눈 몫
        int baseValue = s / n;
        for (int i = 0; i < n; i++) {
            answer[i] = baseValue;
        }
        
        // 나머지를 1씩 분배
        // 뒤에서부터 분배하면 자동으로 오름차순 정렬됨
        int remainder = s % n;
        for (int i = n - remainder; i < n; i++) {
            answer[i]++;
        }
        
        return answer;
    }
}