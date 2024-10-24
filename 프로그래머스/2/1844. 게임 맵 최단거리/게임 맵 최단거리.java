import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0}; // 행 이동
    int[] dy = {0, 1, 0, -1}; // 열 이동
    
    class Point {
        int x, y, distance;
        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Deque<Point> deq = new ArrayDeque<>();
        deq.offerLast(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while (!deq.isEmpty()) {
            Point current = deq.pollFirst();
            
            // 도착지점에 도달한 경우
            if (current.x == n-1 && current.y == m-1) {
                return current.distance;
            }
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                // 맵 범위 내이고, 벽이 아니고, 방문하지 않은 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                   && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    deq.offerLast(new Point(nx, ny, current.distance + 1));
                }
            }
        }
        
        return -1;
    }
}