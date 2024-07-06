package section02.problem01;

import java.util.*;
public class Solution {
    public int solution(String s){
        HashMap<Character, Integer> result = new HashMap<>();

        for(char c : s.toCharArray()){
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            if(result.get(s.charAt(i)) == 1) return i+1;
        }

        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
