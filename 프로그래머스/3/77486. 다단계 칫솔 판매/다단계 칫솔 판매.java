import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // map
        Map<String, Integer> profitMap = new HashMap<>();
        Map<String, String> referralMap = new HashMap<>();
        for(int i = 0; i < enroll.length; i++) {
            profitMap.put(enroll[i], 0); // 0원 으로 초기화
            referralMap.put(enroll[i], referral[i]);
        }
        
        for(int i = 0; i < seller.length; i++) {
            dfs(profitMap, referralMap, seller[i], amount[i]*100);
        }
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = profitMap.get(enroll[i]);
        }
        return answer;
    }
    
    public void dfs(Map<String, Integer> profitMap, Map<String, String> referralMap, String name, int profit) {
        if (profit < 10) {
            profitMap.put(name, profitMap.get(name) + profit);
        } else {
            int ownProfit = (profit * 9 + 9) / 10; // 올림 처리된 자신의 몫
            int referralProfit = profit / 10; // 추천인의 몫

            profitMap.put(name, profitMap.get(name) + ownProfit);

            if (!referralMap.get(name).equals("-")) {
                dfs(profitMap, referralMap, referralMap.get(name), referralProfit);
            }
        }
    }
}