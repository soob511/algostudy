import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a,b)-> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        
        int low = routes[0][0], high = routes[0][1];
        for(int[] route:routes){
            if (route[0]> high){
                answer++;
                low = route[0];
                high = route[1];
            }
            else{
                low = route[0];
                high = Math.min(high, route[1]);
            }
        }
        
        return answer;
    }
}
