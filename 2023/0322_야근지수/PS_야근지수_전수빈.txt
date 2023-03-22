import java.io.*;
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<works.length;i++){
            q.offer(works[i]);
        }
        while(n-->0){
            int work = q.poll();
            if(work==0)break;
            work -= 1;
            q.offer(work);
        }
        for(int work : q){
            answer += Math.pow(work,2);
        }
        
        return answer;
    }
}