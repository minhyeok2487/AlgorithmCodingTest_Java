package section01Simulation.problem04;

import java.util.Arrays;

public class Solution {
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];

        // 1. 초기값
        // c : 가로길이, r : 세로길이
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 1, y = 1; // 초기 위치, 편하게 하기위해 1부터 시작
        int d = 1; // 방향

        // 2. 가로 세로 최소 최대
        int minX = 1;
        int minY = 1;
        int maxX = c;
        int maxY = r;

        // 3. 시계방향 좌석배치
        // k-1번 반복 -> k가 모든 좌석 갯수(c*r)보다 크면 0 -> 할 필요 X
        if(k <= c * r) {
            for (int i = 0; i < k-1; i++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                // 방향 전환 위치가 점점 줄어듬
                if(nx < minX || nx > maxX || ny < minY || ny > maxY){
                    //방향을 바꾸면 한줄이 달라짐
                    if(d == 0) {
                        minY++;
                    }
                    if(d == 1) {
                        minX++;
                    }
                    if(d == 2) {
                        maxY--;
                    }
                    if(d == 3) {
                        maxX--;
                    }
                    d = (d + 1) % 4;

                    //방향을 바꾸고 이동
                    nx = x + dx[d];
                    ny = y + dy[d];
                }
                x = nx;
                y = ny;
            }
            answer[0] = x;
            answer[1] = y;
        }
        return answer;
    }

    //새로운 배열만들기
    public int[] solution2(int c, int r, int k){
        int[] answer = new int[2];
        if(k > c * r) return new int[] {0, 0};
        int[][] seat = new int[c][r];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, count = 1, d = 1;
        while(count < k){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= c || ny < 0 || ny >=r || seat[nx][ny] > 0){
                d = (d + 1) % 4;
                continue;
            }
            seat[x][y] = count;
            count++;
            x = nx;
            y = ny;
        }
        answer[0] = x + 1;
        answer[1] = y + 1;
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
