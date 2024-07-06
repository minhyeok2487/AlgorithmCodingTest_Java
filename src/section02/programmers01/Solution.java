package section02.programmers01;

import java.util.HashMap;

public class Solution {

    public int solution(int[] nums){
        HashMap<Integer, Integer> sh = new HashMap<>();
        for(int x : nums) {
            sh.put(x, sh.getOrDefault(x, 0)+1);
        }
        int size = sh.keySet().size();
        if(size > nums.length/2) {
            return nums.length/2;
        } else {
            return size;
        }
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{3, 1, 2, 3}));
        System.out.println(T.solution(new int[]{3,3,3,2,2,4}));
        System.out.println(T.solution(new int[]{3,3,3,2,2,2}));
    }
}
