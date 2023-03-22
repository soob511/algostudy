import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<works.length; i++) {
            q.offer(works[i]);
        }

        for(int i=-0; i<n; i++) {

            int a = q.poll();

            if(a <= 0) break;
            q.offer(a-1);
        }

        long answer = 0;
        while(!q.isEmpty()) {
            int b = q.poll();
            answer += b * b;
        }
        return answer;

    }
}