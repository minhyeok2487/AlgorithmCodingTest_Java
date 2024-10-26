import java.util.*;

class Solution {
    private HashSet<HashSet<String>> result; // 최종 결과를 저장할 Set
    
    public int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
        
        // 각 불량 사용자 패턴별로 매칭되는 사용자 ID를 저장
        List<List<String>> matchList = new ArrayList<>();
        
        // 각 불량 사용자 패턴에 매칭되는 사용자 ID들을 찾음
        for(String banned: banned_id) {
            List<String> matches = new ArrayList<>();
            for(String user: user_id) {
                if(match(user, banned)) {
                    matches.add(user);
                }
            }
            matchList.add(matches);
        }
        
        // DFS로 가능한 모든 조합을 찾음
        dfs(new HashSet<>(), 0, matchList);
        
        return result.size();
    }
    
    private void dfs(HashSet<String> set, int depth, List<List<String>> matchList) {
        // 모든 불량 사용자를 처리했으면 결과에 추가
        if(depth == matchList.size()) {
            result.add(new HashSet<>(set));
            return;
        }
        
        // 현재 불량 사용자에 매칭되는 사용자 ID들에 대해 반복
        for(String user: matchList.get(depth)) {
            // 이미 선택된 사용자 ID는 건너뜀
            if(!set.contains(user)) {
                set.add(user);
                dfs(set, depth + 1, matchList);
                set.remove(user);
            }
        }
    }
    
    private boolean match(String user, String banned) {
        if(user.length() != banned.length()) {
            return false;
        }
        
        for(int i = 0; i < user.length(); i++) {
            if(banned.charAt(i) != '*' && banned.charAt(i) != user.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}