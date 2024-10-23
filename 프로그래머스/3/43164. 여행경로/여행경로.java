import java.util.*;

class Solution {
    static List<String> answer;
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        answer = null;
        visited = new boolean[tickets.length];
        
        // 출발지가 같은 경우 도착지를 기준으로 정렬
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        List<String> route = new ArrayList<>();
        route.add("ICN");
        
        dfs(tickets, "ICN", route, 0);
        
        return answer.toArray(new String[0]);
    }
    
    public void dfs(String[][] tickets, String current, List<String> route, int count) {
        if(count == tickets.length) {
            // 처음 찾은 경로이거나 더 알파벳 순서가 앞선 경로를 찾은 경우
            if(answer == null) {
                answer = new ArrayList<>(route);
            }
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                route.add(tickets[i][1]);
                
                dfs(tickets, tickets[i][1], route, count + 1);
                
                // 백트래킹
                route.remove(route.size() - 1);
                visited[i] = false;
            }
        }
    }
}