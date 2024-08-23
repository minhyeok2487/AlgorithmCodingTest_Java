package section04_Sorting.problem01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        List<Count> counts = new ArrayList<>();
        for (int i : nums) {
            String binary = Integer.toBinaryString(i);
            int count = 0;
            for (char c : binary.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            counts.add(new Count(i, count));
        }
        counts.sort(Comparator.comparing(Count::getCount)
                .thenComparing(Count::getNum)
        );
        for (int i = 0; i < nums.length; i++) {
            answer[i] = counts.get(i).getNum();
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}

class Count {
    int num;
    int count;

    public Count(int num, int count) {
        this.num = num;
        this.count = count;
    }

    public int getNum() {
        return num;
    }

    public int getCount() {
        return count;
    }
}
