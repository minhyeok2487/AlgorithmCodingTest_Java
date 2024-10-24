import java.util.*;

class Solution {
    // 상하좌우 이동을 위한 방향 배열
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // 퍼즐 조각 정보를 담는 클래스
    class Puzzle {
        List<Point> points;
        int minX, minY, maxX, maxY;
        
        Puzzle() {
            points = new ArrayList<>();
            minX = minY = Integer.MAX_VALUE;
            maxX = maxY = Integer.MIN_VALUE;
        }
        
        // 조각의 좌표를 정규화(왼쪽 상단이 0,0이 되도록)
        void normalize() {
            for (Point p : points) {
                minX = Math.min(minX, p.x);
                minY = Math.min(minY, p.y);
                maxX = Math.max(maxX, p.x);
                maxY = Math.max(maxY, p.y);
            }
            
            List<Point> normalized = new ArrayList<>();
            for (Point p : points) {
                normalized.add(new Point(p.x - minX, p.y - minY));
            }
            points = normalized;
            maxX -= minX;
            maxY -= minY;
            minX = minY = 0;
        }
        
        // 90도 회전
        Puzzle rotate() {
            Puzzle rotated = new Puzzle();
            for (Point p : points) {
                rotated.points.add(new Point(p.y, maxX - p.x));
            }
            rotated.normalize();
            return rotated;
        }
    }
    
    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;
        List<Puzzle> emptySpaces = findPieces(game_board, 0); // 빈 공간 찾기
        List<Puzzle> puzzlePieces = findPieces(table, 1); // 퍼즐 조각 찾기
        
        boolean[] usedPuzzle = new boolean[puzzlePieces.size()];
        int answer = 0;
        
        // 각 빈 공간에 대해
        for (Puzzle space : emptySpaces) {
            // 각 퍼즐 조각에 대해
            for (int i = 0; i < puzzlePieces.size(); i++) {
                if (usedPuzzle[i]) continue;
                
                Puzzle piece = puzzlePieces.get(i);
                boolean matched = false;
                
                // 4번 회전시키면서 확인
                for (int rot = 0; rot < 4 && !matched; rot++) {
                    if (isMatch(space, piece)) {
                        matched = true;
                        usedPuzzle[i] = true;
                        answer += piece.points.size();
                        break;
                    }
                    piece = piece.rotate();
                }
                if (matched) break;
            }
        }
        
        return answer;
    }
    
    // BFS로 연결된 영역(조각) 찾기
    private List<Puzzle> findPieces(int[][] board, int target) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<Puzzle> pieces = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == target && !visited[i][j]) {
                    Puzzle piece = new Puzzle();
                    Queue<Point> queue = new LinkedList<>();
                    Point start = new Point(i, j);
                    
                    queue.offer(start);
                    visited[i][j] = true;
                    
                    while (!queue.isEmpty()) {
                        Point curr = queue.poll();
                        piece.points.add(curr);
                        
                        for (int d = 0; d < 4; d++) {
                            int nx = curr.x + dx[d];
                            int ny = curr.y + dy[d];
                            
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n 
                                && board[nx][ny] == target && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                queue.offer(new Point(nx, ny));
                            }
                        }
                    }
                    
                    piece.normalize();
                    pieces.add(piece);
                }
            }
        }
        
        return pieces;
    }
    
    // 두 조각이 일치하는지 확인
    private boolean isMatch(Puzzle space, Puzzle piece) {
        if (space.points.size() != piece.points.size()) return false;
        if (space.maxX != piece.maxX || space.maxY != piece.maxY) return false;
        
        // 각 점의 상대적 위치가 모두 일치하는지 확인
        Set<String> spacePoints = new HashSet<>();
        for (Point p : space.points) {
            spacePoints.add(p.x + "," + p.y);
        }
        
        for (Point p : piece.points) {
            if (!spacePoints.contains(p.x + "," + p.y)) {
                return false;
            }
        }
        
        return true;
    }
}