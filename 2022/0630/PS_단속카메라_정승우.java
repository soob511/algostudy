import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int cnt = Integer.MIN_VALUE;
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1],b[1]));


        for(int i=0; i<routes.length; i++) {
            if(cnt < routes[i][0]) {
                cnt = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}