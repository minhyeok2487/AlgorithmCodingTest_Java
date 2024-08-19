import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<String> deque = new ArrayDeque<>();
        String[] sList = s.split("");
        for (String s1 : sList) {
            if (s1.equals("(")) {
                deque.offerLast(s1);
            } else {
                String check = deque.pollLast();
                if (check == null) {
                    answer = false;
                    break;
                } else if (check.equals(")")) {
                    answer = false;
                    break;
                }
            }
        }
        
        if(deque.size() > 0) {
            answer = false;
        }
        return answer;
    }
}