class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        
        int[] pulse1 = new int[n];
        int[] pulse2 = new int[n];
        
        for(int i = 0; i < n; i++) {
            pulse1[i] = sequence[i] * (i % 2 == 0 ? 1 : -1);
            pulse2[i] = sequence[i] * (i % 2 == 0 ? -1 : 1);
        }
        
        long max1 = kadane(pulse1);
        long max2 = kadane(pulse2);
        
        return Math.max(max1, max2);
    }
    
    private long kadane(int[] sequence) {
        long maxSum = sequence[0];
        long currentSum = sequence[0];
        
        for(int i = 1; i < sequence.length; i++) {
            // 현재까지의 합 계속 갱신(시작 갱신)
            currentSum = Math.max(sequence[i], currentSum + sequence[i]);
            
            // 전체 최대값 갱신
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}