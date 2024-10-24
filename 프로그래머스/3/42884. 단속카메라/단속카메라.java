import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 진입 지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);
        
        int count = 1;  // 필요한 카메라 수
        int lastCamera = routes[0][1];  // 마지막 카메라 위치
        
        // 모든 차량의 경로를 확인
        for (int i = 1; i < routes.length; i++) {
            // 현재 차량의 진입 지점이 마지막 카메라 위치보다 뒤에 있으면
            if (routes[i][0] > lastCamera) {
                count++;  // 새로운 카메라 필요
                lastCamera = routes[i][1];  // 카메라 위치 업데이트
            } else {
                // 현재 차량의 진출 지점이 더 앞에 있다면, 카메라 위치를 앞으로 당김
                lastCamera = Math.min(lastCamera, routes[i][1]);
            }
        }
        
        return count;
    }
}