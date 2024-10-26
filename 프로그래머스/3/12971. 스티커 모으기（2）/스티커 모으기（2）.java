class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        
        // 스티커가 1장인 경우
        if (n == 1) return sticker[0];
        // 스티커가 2장인 경우
        if (n == 2) return Math.max(sticker[0], sticker[1]);
        
        // 첫 번째 스티커를 선택하는 경우 (마지막 스티커는 선택 불가)
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];  // 두 번째는 선택 불가
        for (int i = 2; i < n-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }
        
        // 첫 번째 스티커를 선택하지 않는 경우 (마지막 스티커 선택 가능)
        int[] dp2 = new int[n];
        dp2[0] = 0;  // 첫 번째는 선택하지 않음
        dp2[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }
        
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}