import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        // 각 횟수별로 만들 수 있는 수의 집합을 저장할 배열
        Set<Integer>[] dp = new Set[9];
        
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }
        
        // N을 i번 사용해서 만들 수 있는 값을 미리 저장
        int baseNumber = N;
        for (int i = 1; i <= 8; i++) {
            dp[i].add(baseNumber);
            baseNumber = baseNumber * 10 + N;
        }
        
        // 1부터 8까지 경우를 살펴보며 가능한 값을 만듦
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int x : dp[j]) {
                    for (int y : dp[i - j]) {
                        dp[i].add(x + y);
                        dp[i].add(x - y);
                        dp[i].add(x * y);
                        if (y != 0) {
                            dp[i].add(x / y);
                        }
                    }
                }
            }
            // number를 찾으면 바로 return
            if (dp[i].contains(number)) {
                return i;
            }
        }
        
        return -1; // 8번 이내에 만들 수 없을 경우
    }
}