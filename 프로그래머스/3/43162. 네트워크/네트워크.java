class Solution {

    public int solution(int n, int[][] computers) {
        // 방문 체크
        boolean[] visited = new boolean[n];
        
        // 네트워크 갯수
        int networkCount = 0;
        
        for (int i = 0; i < n; i++) {
            // 방문하지 않은 노드일 때, DFS 시작과 네트워크 갯수 증가
            if (!visited[i]) { 
                dfs(computers, visited, i, n);
                networkCount++;
            }
        }
        
        return networkCount;
    }
    
    private static void dfs(int[][] computers, boolean[] visited, int i, int n) {
        visited[i] = true; // 방문 처리

        for (int j = 0; j < n; j++) {
            // 서로 연결되어 있고 방문하지 않았으면 -> DFS 재귀 -> 하나의 네트워크로 처리됨
            if (computers[i][j] == 1 && !visited[j]) {
                dfs(computers, visited, j, n);
            }
        }
    }
}