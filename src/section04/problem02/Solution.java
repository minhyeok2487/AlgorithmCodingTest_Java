package section04.problem02;
import java.util.*;
class Solution {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        HashMap<Integer, Integer> nh = new HashMap<>();

        for (int num : nums) {
            nh.put(num, nh.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);

        int idx = 0;
        for (int num : nums) {
            if(nh.get(num) == 0) continue;
            answer[idx] = num;
            idx++;
            nh.put(num, nh.get(num) - 1);
            nh.put(num*2, nh.get(num*2) - 1);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
