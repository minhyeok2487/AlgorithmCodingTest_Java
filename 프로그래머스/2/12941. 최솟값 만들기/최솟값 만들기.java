import java.util.*;

class Solution
{
    public int solution(int[] A, int[] B)
    {
        int answer = 0;
        
        Arrays.sort(A);  // A를 오름차순 정렬
        Arrays.sort(B);  // B를 오름차순 정렬
        
        // A는 작은 값부터, B는 큰 값부터 곱셈
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }
        
        return answer;
    }
}
