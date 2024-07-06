package section02.programmers02;

import java.util.Arrays;

public class Solution {

    public boolean solution(String[] phone_book) {
        // 전화번호부 정렬
        Arrays.sort(phone_book);

        // 인접한 두 번호 비교
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(T.solution(new String[]{"123","456","789"}));
        System.out.println(T.solution(new String[]{"12","123","1235","567","88"}));
    }
}
