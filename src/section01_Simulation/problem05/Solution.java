package section01_Simulation.problem05;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int solution(int[] nums){
        int answer = 0;

        boolean[] answers = new boolean[nums.length];

        // 감소 -> 중가
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i] > nums[i+1] && nums[i+1] < nums[i+2]) {
                answers[i+1] = true;
            }
        }

        // 같음
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                answers[i] = true;
                answers[i+1] = true;
            }
        }

        // true - true사이 거리가 가장 긴것
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < answers.length; i++) {
            if(answers[i]) {
                result.add(i);
            }
        }
        result.add(nums.length-1);
        for (int i = 0; i < result.size()-1; i++) {
            if((result.get(i+1)-result.get(i)) > answer) {
                answer = result.get(i+1)-result.get(i)+1;
            }
        }
        return answer;
    }

    public int solution2(int[] nums){
        //봉우리 찾기
        int answer = 0;
        int n = nums.length;
        ArrayList<Integer> peaks = new ArrayList<>();
        for(int i = 1; i < n-1; i++){
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                peaks.add(i);
            }
        }

        //양쪽으로 감소하는 곳 길이 구하기
        for(int x : peaks){
            int left = x;
            int right = x;
            int cnt = 1;
            while(left-1 >= 0 && nums[left-1] < nums[left]){
                left--;
                cnt++;
            }
            while(right+1 < n && nums[right] > nums[right+1]){
                right++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
