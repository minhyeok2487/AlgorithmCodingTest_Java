package section06_DFS.problem01;

import java.util.*;

class Solution {

    int answer, target, stop;
    ArrayList<Integer> nums;
    int[] ch;
    boolean flag;

    public void DFS(int L, int number) {
        if (flag)
            return;
        if (L == stop) {
            if (number > target) {
                answer = number;
                flag = true;
            }
        } else {
            for (int i = 0; i < stop; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L + 1, number * 10 + nums.get(i));
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int n) {
        // 초기화
        answer = 0;
        flag = false;
        nums = new ArrayList<>();
        target = n;

        // 숫자 분리
        int tmp = n;
        while (tmp > 0) {
            int t = tmp % 10;
            nums.add(t);
            tmp = tmp / 10;
        }
        nums.sort(Comparator.comparingInt(a -> a));

        // DFS
        stop = nums.size();
        ch = new int[stop];
        DFS(0, 0);
        if (!flag)
            return -1;
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
