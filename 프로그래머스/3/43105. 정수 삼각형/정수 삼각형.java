import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        // 삼각형의 마지막 층을 복사하여 dp 배열로 사용
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle[n - 1][i];
        }
        
        // 아래에서부터 위로 올라가며 최대 경로 계산
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.max(dp[j], dp[j + 1]) + triangle[i][j];
            }
        }
        
        // dp[0]에 최종 결과가 저장됨
        return dp[0];
    }
}
