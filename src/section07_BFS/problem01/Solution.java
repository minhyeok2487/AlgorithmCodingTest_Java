package section07_BFS.problem01;

import java.util.*;

class Solution {
    public int solution(int[] nums){
        int n = nums.length;
        int[] ch = new int[n]; // 이미 지나온 곳 체크

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0); // 시작 지점
        ch[0] = 1;
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int x = Q.poll();
                for(int j = 0; j <= nums[x]; j++) {
                    int nx = x + j;
                    if(nx == n - 1) return L + 1;
                    if(nx < n && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
