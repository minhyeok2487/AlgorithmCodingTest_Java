package section01.problem02;

import java.util.*;
class Solution {
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        //초기화
        answer[0] = 0;
        answer[1] = 0;
        int direction = 0;
        for (int i = 0; i < k; i++) {
            boolean change = false; //방향전화 변수
            // 넘어가면 방향 전환
            if (direction == 0 && answer[1] == board.length-1) {change = true;}
            if (direction == 1 && answer[0] == board.length-1) {change = true;}
            if (direction == 2 && answer[1] == 0) {change = true;}
            if (direction == 3 && answer[0] ==0 ) {change = true;}

            // 이동
            if(!change) {
                if (direction == 0 && answer[1] != board.length-1) {
                    if(board[answer[0]][answer[1]+1] == 0) {
                        answer[1]++;
                    } else {
                        change = true;
                    }
                }
                if (direction == 1 && answer[0] != board.length-1) {
                    if(board[answer[0]+1][answer[1]] == 0) {
                        answer[0]++;
                    } else {
                        change = true;
                    }
                }
                if (direction == 2 && answer[1] != 0) {
                    if(board[answer[0]][answer[1]-1] == 0) {
                        answer[1]--;
                    } else {
                        change = true;
                    }
                }
                if (direction == 3 && answer[0] !=0 ) {
                    if(board[answer[0]-1][answer[1]] == 0) {
                        answer[0]--;
                    } else {
                        change = true;
                    }
                }
            }

            // 방향전환
            if(change) {
                if(direction<=2) {
                    direction++;
                } else {
                    direction=0;
                }
            }
        }
        return answer;
    }

    public int[] solution2(int[][] board, int k){
        int[] answer = new int[2];
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 1, count = 0;
        while(count < k){
            count++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1){
                d = (d + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
