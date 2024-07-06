package section07_BFS.programmers01;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(numbers[0]);
        Q.offer(-numbers[0]);

        for(int i = 1; i < numbers.length; i++) {
            int len = Q.size();
            for (int j=0; j < len; j++) {
                int x = Q.poll();
                Q.offer(x + numbers[i]);
                Q.offer(x - numbers[i]);
            }
        }

        while(!Q.isEmpty()) {
            if(Q.poll() == target) {
                answer++;
            }
        }

        return answer;
    }

    public int solutionV2(int[] numbers, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        for (int number : numbers) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                queue.offer(current + number);
                queue.offer(current - number);
            }
        }

        return (int) queue.stream().filter(sum -> sum == target).count();
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(T.solution(new int[]{4, 1, 2, 1}, 4));
        System.out.println(T.solutionV2(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(T.solutionV2(new int[]{4, 1, 2, 1}, 4));
    }
}
