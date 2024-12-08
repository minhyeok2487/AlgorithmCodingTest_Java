import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        // 최단 거리 계산을 위한 배열
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1); // 초기값은 -1로 설정
        distances[destination] = 0; // 목적지의 거리 0으로 초기화

        // BFS 수행
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) { // 방문하지 않은 노드만 처리
                    distances[neighbor] = distances[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        // 결과 생성
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distances[sources[i]];
        }

        return answer;
    }
}
