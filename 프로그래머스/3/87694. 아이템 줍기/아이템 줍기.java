import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0}; // 행 이동
    int[] dy = {0, 1, 0, -1}; // 열 이동
    
    class Node {
        int x;
        int y;
        int count;
        
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 건너뛰는 경우를 포함할 수 있어 전체적인 크기를 두배로 늘림
        Boolean[][] road = new Boolean[101][101];
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        // 전체 경로 구하기
        for (int i = 0; i< rectangle.length; i++) {
            int[] now = rectangle[i];
            for (int j = 0; j < 4; j++) now[j] *= 2;
            
            // Boolean 배열 기본 값 = null
            // 직사각형 내부 = false, 빗변 = true
            // road[x][y] != false : 다른 직사각형의 내부도 아닐때
            // (null 이면 기본값으로 체크되지 않음, true면 같은 빗변임) 
            for (int x = now[0]; x <= now[2]; x++) {
                for (int y = now[1]; y <= now[3]; y++) {
                    road[x][y] = (x == now[0] || x == now[2] 
                                  || y == now[1] || y == now[3]) 
                        && road[x][y] != Boolean.FALSE;
                }
            }
        }
        
        // 출발
        Deque<Node> deq = new ArrayDeque<>();
        road[characterX][characterY] = false; //지나간 곳 false로 변경
        deq.offer(new Node(characterX, characterY, 0));
        
        while(!deq.isEmpty()) {
            Node node = deq.poll();
            
            if(node.x == itemX && node.y == itemY) {
                return node.count / 2;
            }
            
            for(int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                if(x < 2 || y < 2 || x > 100 || y > 100) continue;
                if(road[x][y] != Boolean.TRUE) continue;
                
                road[x][y] = false;
                deq.offer(new Node(x, y, node.count + 1));
            }
        }
        return -1;
    }
}