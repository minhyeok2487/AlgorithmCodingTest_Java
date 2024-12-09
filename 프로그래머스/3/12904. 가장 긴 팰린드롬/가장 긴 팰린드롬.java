import java.util.*;

class Solution
{
    static String s;
    
    public int solution(String s)     {
        this.s = s;
 
        for(int i = s.length() ; i > 0 ; i--) {    
            for(int j = 0 ; j+i <= s.length() ; j++) {
                if(isPalindrome(j, j + i - 1)) {
                    return i;
                }
            }
        }
 
        return 0;
    }
    
    private static boolean isPalindrome(int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        
        return true;        
    }
}