import java.util.*;

class Solution {
    // 부모 노드를 찾는 함수
    private int findParent(int[] parent, int x) {
        // 자기 자신이 부모라면 그대로 반환
        if (parent[x] == x) {
            return x;
        }
        
        // 경로 압축을 위해 재귀적으로 부모를 찾아 갱신
        return parent[x] = findParent(parent, parent[x]);
    }
    
    // 두 노드를 연결하는 함수
    private void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a); // a의 최상위 부모 찾기
        b = findParent(parent, b); // b의 최상위 부모 찾기
        
        // 더 작은 번호를 가진 노드가 부모가 되도록 설정
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    
    public int solution(int n, int[][] costs) {
        // 1. 비용을 기준으로 오름차순 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        // 2. 부모 배열 초기화
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int totalCost = 0; // 총 비용
        int connectedEdges = 0; // 연결된 간선 수
        
        // 3. 비용이 적은 간선부터 선택하면서 MST 구성
        for (int[] cost : costs) {
            int from = cost[0]; // 시작
            int to = cost[1]; // 도착
            int weight = cost[2]; // 건설 비용
            
            // 사이클이 생기지 않는 경우에만 연결
            if (findParent(parent, from) != findParent(parent, to)) {
                unionParent(parent, from, to);
                totalCost += weight;
                connectedEdges++;
                
                // 모든 섬이 연결되었다면 종료
                if (connectedEdges == n - 1) {
                    break;
                }
            }
        }
        
        return totalCost;
    }
}