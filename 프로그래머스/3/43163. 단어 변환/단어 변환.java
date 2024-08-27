import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 단어 목록이 target을 포함하지 않으면 0 리턴
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        // BFS 초기화
        Deque<Word> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        deque.offer(new Word(begin, 0));
        
        while (!deque.isEmpty()) {
            Word current = deque.poll();
            String currentWord = current.word;
            int currentStep = current.step;
            
            // 현재 단어가 target과 일치하면 완료
            if (currentWord.equals(target)) {
                return currentStep;
            }
            
            // words 배열의 각 단어를 확인
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(currentWord, words[i])) {
                    visited[i] = true;
                    deque.offer(new Word(words[i], currentStep + 1));
                }
            }
        }
        
        // 변환할 수 없는 경우 0 반환
        return 0;
    }
    
    // 두 단어가 한 글자만 다른지 확인하는 메서드
    private boolean canConvert(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        return diffCount == 1;
    }
    
    // 단어와 변환 단계를 담는 클래스
    class Word {
        String word;
        int step;
        
        Word(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}