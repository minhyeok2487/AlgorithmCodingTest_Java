package section04.programmers01;

import java.util.Arrays;

public class Solution {
    public String solution(int[] numbers) {
        // 숫자들을 문자열로 변환
        String[] strNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 커스텀 정렬
        Arrays.sort(strNumbers, (a, b) -> (b+a).compareTo(a+b));

        // 0으로만 구성된 경우 "0" 반환
        if(strNumbers[0].equals("0")) return "0";

        // 정렬된 숫자들을 이어붙여 결과 생성
        StringBuilder answer = new StringBuilder();
        for(String s : strNumbers) {
            answer.append(s);
        }

        return answer.toString();
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{6, 10, 2}));
        System.out.println(T.solution(new int[]{3, 30, 34, 5, 9}));
    }
}
