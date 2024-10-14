import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow = Integer.MAX_VALUE, minCol = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE, maxCol = Integer.MIN_VALUE;
        
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }
}