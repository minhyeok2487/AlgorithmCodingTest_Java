import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 양방향 간선 추가
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        return bfs(n);
    }
    
    private int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);  // 방문하지 않은 노드는 -1로 초기화
        
        // 시작점 설정
        queue.offer(1);
        distance[1] = 0;
        
        // BFS 탐색
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph.get(current)) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }
        
        // 최대 거리 찾기
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, distance[i]);
        }
        
        // 최대 거리에 있는 노드 개수 세기
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDistance) {
                count++;
            }
        }
        
        return count;
    }
}