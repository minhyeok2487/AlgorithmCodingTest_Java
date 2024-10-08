package section05_Greedy.problem01;

import java.util.*;

class Solution {
    public int solution(int[] nums, int m){
        int answer = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if(nums[left] + nums[right] <= m) {
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
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{86, 95, 107, 67, 38, 49, 116, 22, 78, 53}, 150));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
