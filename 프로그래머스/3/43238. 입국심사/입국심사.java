import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        // 걸리는 시간 최소
        // n의 범위가 크다 -> 이분 탐색
        Arrays.sort(times);
        long left = 1;
        long right = (long) times[times.length-1]*n;
        long answer = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (can(n, times, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
    
    private boolean can(int n, int[] times, long checkTime) {
        long sum = 0;
        for (int t : times) {
            sum += checkTime / t;
            // 최적화: 이미 n명을 처리할 수 있다면 더 계산할 필요 없음
            if (sum >= n) return true;  
        }
        return sum >= n;
    }
}