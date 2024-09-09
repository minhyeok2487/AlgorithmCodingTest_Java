import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n +1][m +1];
        
        //시작점 초기화
        dp[1][1] = 1;
        
        // puddles 위치를 -1로 설정하여 체크
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        // DP 배열을 채우며 각 지점까지의 경로의 수 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) { //웅덩이인 경우 0
                    dp[i][j] = 0;
                } else {
                    if (i > 1) dp[i][j] += dp[i-1][j];
                    if (j > 1) dp[i][j] += dp[i][j-1];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        
        return dp[n][m];
    }
}