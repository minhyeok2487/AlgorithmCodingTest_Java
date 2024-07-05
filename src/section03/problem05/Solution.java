package section03.problem05;
import java.util.*;
class Solution {
    public int[] solution(int[][] tasks){
        int n = tasks.length;
        int[] answer = new int[n];
        // 1. 작업번호가 추가된 List
        LinkedList<int[]> programs = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            programs.add(new int[]{tasks[i][0], tasks[i][1], i});
        }

        // 2. 호출 시간으로 오름차순 정렬
        programs.sort(Comparator.comparingInt(value -> value[0]));

        /**
         * 3. 시뮬레이션
         */
        // 우선순위 큐(대기열) 생성, 작업 시간이 값으면 작업 번호가 작은 순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int fT = 0, idx = 0; // 초기값

        while (!programs.isEmpty() || !pq.isEmpty()) {
            if (pq.isEmpty()) { //우선순위 큐가 비어있으면 종료 시간을 호출 시간으로 변경한다.
                fT = Math.max(fT, programs.peek()[0]);
            }
            //작업이 남아있고 호출시간이 작업시간보다 짧다면(작업이 먼저 도착->대기)
            while (!programs.isEmpty() && programs.peek()[0] <= fT) {
               int[] x = programs.pollFirst(); //LinkedList의 첫번째 요소를 반환하면서 제거
               pq.add(new int[]{x[1], x[2]}); //대기열에는 작업시간과 작업 번호를 넣는다.
            }

            // 우선순위 큐에서 꺼내서 작업
            int[] ex = pq.poll();
            fT = fT + ex[0]; // 작업시간 더함
            answer[idx++] = ex[1]; // 작업번호 추가
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
