import java.util.*;

class Solution {
    // 방향 벡터 (상, 하, 좌, 우)
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // 방문 여부를 체크하기 위한 배열
        boolean[][] visited = new boolean[n][m];
        
        // BFS를 위한 큐 초기화
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0, 1}); // 시작점 (0, 0)과 초기 거리 1
        
        // BFS 실행
        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            // 목표 지점에 도달한 경우
            if (x == n - 1 && y == m - 1) {
                return distance;
            }
            
            // 4가지 방향으로 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 맵 범위 내에 있고, 방문하지 않았으며, 이동할 수 있는 곳이라면
                if (nx >= 0 && ny >= 0 && nx < n && ny < m
                   && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true; // 방문 처리
                    deque.add(new int[]{nx, ny, distance + 1}); // 큐에 추가
                }
            }
        }

        // 목표 지점에 도달할 수 없는 경우
        return -1;
    }
}