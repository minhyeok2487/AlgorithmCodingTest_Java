package section03.problem02;
import java.util.*;
class Solution {
    public String solution(String s){
        String answer = "";
        Stack<String> st = new Stack<>(); // 문자열을 담는 스택
        for (char c : s.toCharArray()) {
            if(c == ')') { //닫는 괄호를 만나면
                String tmp = "";
                while (!st.empty()) { //반복
                    String t = st.pop(); //pop()으로 꺼냄
                    if(t.equals("(")) { //여는 괄호 만날 때까지 꺼내서 저장 tmp에 저장
                        String num = "";
                        // 몇번 반복할 것인가? -> 여는 괄호 앞에 숫자 ->3(2(ac)) 이런식 으로도 받을 수 있어서 while로 반복
                        while (!st.empty() && Character.isDigit(st.peek().charAt(0))) {
                            num = st.pop() + num;
                        }
                        // 반복횟수 -> int로 변경
                        int cnt = 0;
                        if(num.equals("")) cnt = 1;
                        else cnt = Integer.parseInt(num);

                        String res = "";
                        for (int i = 0; i < cnt; i++) {
                            res += tmp;
                        }
                        st.push(res);
                        break; //종료하고 다시 닫는 괄호 만날 때까지 stack에 추가
                    } else {
                        tmp = t + tmp;
                    }
                }
            } else {
                st.push(String.valueOf(c));
            }
        }
        for(String x : st) {
            answer += x;
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
