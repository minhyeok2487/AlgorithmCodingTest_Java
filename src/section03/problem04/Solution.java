package section03.problem04;

import java.util.*;
class Solution {
    // 1. 문자열로 들어온 시간을 숫자로 변경하는 메소드
    public int getTime(String time){
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H*60+M;
    }
    public int solution(int[] laser, String[] enter){
        int answer = 0;
        int n = enter.length;

        // 2. enter(고객) -> 시간(int) / 시술 번호 리스트로 변경
        int[][] inList = new int[n][2];
        for (int i = 0; i < n; i++) {
            inList[i][0] = getTime(enter[i].split(" ")[0]);
            inList[i][1] = Integer.parseInt(enter[i].split(" ")[1]);
        }

        /**
         * 시뮬레이션
         */
        Queue<Integer> q = new LinkedList<>(); //대기열

        // 첫 손님
        q.offer(inList[0][1]);
        int finishTime = inList[0][0];
        int pos = 1;
        for (int t = finishTime; t < 1200; t++) { //1200초(20시 까지) 시뮬레이션
            if (pos < n && t == inList[pos][0]) { // 고객이 오는 시간이 됬을 때
                if (q.isEmpty() && inList[pos][0] > finishTime) {
                    // 만약 대기열이 없다면 finishTime변경하여 아래 로직이 바로 실행되게함
                    finishTime = inList[pos][0];
                }
                // 일단 대기열에 고객 추가
                q.offer(inList[pos][1]);
                pos++;
            }

            if (t == finishTime && !q.isEmpty()) { // 시술이 끝난 시간인데 대기열이 비어있지않다면
                // 대기열에서 꺼내서 시술 완료 시간 변경
                finishTime += laser[q.poll()];
            }

            // 대기열 최대값 갱신
            answer = Math.max(answer, q.size());
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
