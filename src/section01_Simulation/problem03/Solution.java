package section01_Simulation.problem03;

public class Solution {
    public int solution(int[][] board){
        int answer = 0;
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 0;
        int x2 = 0, y2 = 0, d2 = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    x = i;
                    y = j;
                }
                if (board[i][j] == 3) {
                    x2 = i;
                    y2 = j;
                }
            }
        }
        while(true){
            boolean check = true;
            boolean check2 = true;
            if(x == x2 && y == y2) {
                answer = count;
                break;
            }
            if (count > 10000) {
                break;
            }
            int nx = x + dx[d];
            int ny = y + dy[d];
            int nx2 = x2 + dx[d2];
            int ny2 = y2 + dy[d2];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1){
                d = (d + 1) % 4;
                check = false;
            }
            if(nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= n || board[nx2][ny2] == 1){
                d2 = (d2 + 1) % 4;
                check2 = false;
            }

            if (check) {
                x = nx;
                y = ny;
            }
            if (check2) {
                x2 = nx2;
                y2 = ny2;
            }
            count++;
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
