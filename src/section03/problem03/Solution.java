package section03.problem03;
import java.util.*;
class Solution {
    public int[] solution(int[] arrival, int[] state){
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n = arrival.length, prev = 1;
        int[] answer = new int[n];

        for (int t = 0, i = 0, cnt =0; ; t++) {
            if(enter.isEmpty() && exit.isEmpty() && i < n) {
                // t초에 사용하는 사원이 없다.
                if(t < arrival[i]) {
                    t = arrival[i];
                    prev = 1;
                }
            }
            while (i < n && arrival[i] <= t) {
                if (state[i] == 0) enter.offer(i);
                else exit.offer(i);
                i++;
            }
            if(prev == 1) {
                if(!exit.isEmpty()) {
                    answer[exit.poll()] = t;
                    prev = 1;
                } else {
                    answer[enter.poll()] = t;
                    prev = 0;
                }
            } else if (prev == 0) {
                if(!enter.isEmpty()) {
                    answer[enter.poll()] = t;
                    prev = 0;
                } else {
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }
            cnt++;
            if(cnt==n) break;;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        /**
         * 0초 : 0번 사원 나감
         * 1초 : 1초 전에 0번 사원이 나갔기 때문에 -> 나가는 사원이 나감 -> 1초에 나가는 사원 3번
         * 2초 : 1초 전에 3번 사원이 나갔기 때문에 ->  나가는 사원이 나감 -> 2초에 나가는 사원 없음 -> 1번 사원 들어옴
         * 3초 : 1초 전에 1번  사원이 들어옴 -> 들어오는 사원 -> 2번 사원 들어옴
         * 4초 : 1초 전에 2번 사원 들어옴 -> 들어오는 사원 -> 4번 사원 들어옴
         * 5초 : 1초 전에 4번 사원 들어옴 -> 들어오는 사원 -> 5번 사원 들어옴
         * 6초 : 1초 전에 5번 사원 들어옴 -> 들어오는 사원 -> 없음 -> 나가는 사원 없음 -> 이용 안함
         * 7초 : 나가는 사원 없음
         * 8초 6번 나가고 9초 7번 들어옴
         */
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
