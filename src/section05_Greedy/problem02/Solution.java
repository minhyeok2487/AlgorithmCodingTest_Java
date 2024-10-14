package section05_Greedy.problem02;

import java.util.*;

class Solution {
    public int solution(int[] nums){
        // 5키로 이하로 움직일 수 있음
        int answer = 0;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if(nums[left] + nums[right] <= 5) {
                answer++;
                left++;
                right--;
            } else {
                answer++;
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
