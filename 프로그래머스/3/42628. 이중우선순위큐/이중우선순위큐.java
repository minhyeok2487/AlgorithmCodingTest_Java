import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        List<Integer> result = new ArrayList<>();
        for(String o : operations) {
            String[] check = o.split(" ");
            if (check[0].equals("I")) {
                result.add(Integer.parseInt(check[1]));
            } else {
                if (Integer.parseInt(check[1]) == 1) {
                    if (!result.isEmpty()) {
                        result.remove(result.size()-1);  
                    }
                } else {
                    if (!result.isEmpty()) {
                        result.remove(0);    
                    }
                }
            }
            Collections.sort(result);
        }
        if (result.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = result.get(result.size()-1);
            answer[1] = result.get(0);
        }
        return answer;
    }
}