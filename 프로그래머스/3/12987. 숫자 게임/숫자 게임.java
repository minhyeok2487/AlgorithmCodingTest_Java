import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        List<Integer> listA = new ArrayList<>();
        for (int i : A) {
            listA.add(i);
        }
        
        List<Integer> listB = new ArrayList<>();
        for (int i : B) {
            listB.add(i);
        }
        
        Collections.sort(listA);
        Collections.sort(listB);
        int num = 0;
        for (int i = 0; i < listA.size(); i++) {
            for (int j = num; j < listB.size(); j++) {
                if (listA.get(i) < listB.get(j)) {
                    answer++;
                    num = j + 1;
                    break;
                }
                
            }
        }
        
        return answer;
    }
}