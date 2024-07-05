package section08_Graph.problem02;

import java.util.*;

class Solution {
    public int solution(int[][] routes, int s, int e){
        // 각 정류장에서 갈 수 있는 노선들을 저장하는 해시맵
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length;

        // 그래프 구성: 각 정류장에서 이용 가능한 노선들을 연결
        for(int i = 0; i < n; i++){
            for(int x : routes[i]){
                graph.putIfAbsent(x, new HashSet<Integer>());
                graph.get(x).add(i);
            }
        }

        // BFS를 위한 큐 초기화
        Queue<Integer> Q = new LinkedList<>();
        // 방문한 노선을 체크하는 배열
        int[] ch = new int[n];
        Q.offer(s);
        int L = 0; // 환승 횟수

        // BFS 시작
        while (!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int curStop = Q.poll();
                // 현재 정류장에서 탈 수 있는 모든 노선 확인
                for(int line : graph.get(curStop)) {
                    if(ch[line] == 1) continue; // 이미 탄 노선이면 스킵
                    ch[line] = 1; // 노선 방문 체크
                    // 해당 노선의 모든 정류장 확인
                    for(int stop : routes[line]) {
                        if(stop == e) return L; // 목적지 도착
                        Q.offer(stop);
                    }
                }
            }
            L++; // 환승 횟수 증가
        }
        return -1; // 목적지에 도달할 수 없는 경우
    }

    public static void main(String[] args){
        Solution T = new Solution();
        // 테스트 케이스 실행
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}