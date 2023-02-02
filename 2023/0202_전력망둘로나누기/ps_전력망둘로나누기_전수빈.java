import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[][] map = new int[n+1][n+1];
        for(int i=0;i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            map[a][b] = map[b][a] = 1;
        }
        
        for(int i=0;i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            map[a][b] = map[b][a] = 0;
            boolean[] visit = new boolean[n+1];
            int cnt = 0;
            if(!visit[a]){
                 cnt = 1;
                 Queue<Integer> q = new LinkedList<>();
                 q.add(a);
                 while(!q.isEmpty()){
                    int p = q.poll();
                    visit[p] = true;
                    for(int s=1;s<=n;s++){
                        if(map[p][s]==1&&!visit[s]){
                         q.add(s);
                         cnt++;
                        }
                    }
                }
            }
            answer = Math.min(answer,Math.abs(n-(2*cnt)));
            map[a][b] = map[b][a] = 1;
        }
        return answer;
    }
}