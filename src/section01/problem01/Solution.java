package section01.problem01;
import java.util.*;

public class Solution {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        int[] temps = new int[n];
        for (int i = 1; i < n+1; i++) {
            int temp = i;
            for (int j = 0; j < ladder.length; j++) {
                for (int k = 0; k < ladder[j].length; k++) {
                    if (temp == ladder[j][k]) {
                        temp++;
                        break;
                    }
                    if (temp == ladder[j][k] +1) {
                        temp--;
                        break;
                    }
                }
            }
            temps[temp-1] = i;
        }

        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < temps.length; i++) {
            answer[i] = LETTERS.substring(temps[i]-1, temps[i]).charAt(0);
        }

        return answer;
    }

    public char[] solution2(int n, int[][] ladder){
        char[] answer = new char[n];
        for(int i = 0; i < n; i++){
            answer[i] = (char)(i + 65);
        }

        for(int[] line : ladder){
            for(int x : line){
                char tmp = answer[x];
                answer[x] = answer[x-1];
                answer[x-1] = tmp;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
