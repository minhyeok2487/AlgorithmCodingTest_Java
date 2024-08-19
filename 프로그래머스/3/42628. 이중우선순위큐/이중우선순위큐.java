import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                minHeap.add(number);
                maxHeap.add(number);
            } else if (command.equals("D")) {
                if (number == 1) {
                    if (!maxHeap.isEmpty()) {
                        int max = maxHeap.poll();
                        minHeap.remove(max);
                    }
                } else {
                    if (!minHeap.isEmpty()) {
                        int min = minHeap.poll();
                        maxHeap.remove(min);
                    }
                }
            }
        }

        int[] answer = new int[2];
        if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            answer[0] = maxHeap.peek();
            answer[1] = minHeap.peek();
        }

        return answer;
    }
}
