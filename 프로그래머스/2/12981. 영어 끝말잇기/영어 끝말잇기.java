import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i=1; i<words.length; i++) {
            String[] pre = words[i-1].split("");
            String[] next = words[i].split("");
            
            // 1.끝말잇기가 성립이 안될때
            if (!pre[pre.length-1].equals(next[0])) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
            
            // 2. 같은 단어가 나왔을때
            if (list.contains(words[i])) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            } else {
                list.add(words[i]);
            }
        }
        

        return answer;
    }
}