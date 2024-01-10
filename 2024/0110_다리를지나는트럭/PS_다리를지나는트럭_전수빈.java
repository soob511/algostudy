import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck) {
        int answer = 0;
        int w = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<truck.length;i++){
            while(true){
                answer++;
                if(q.isEmpty()){
                    q.add(truck[i]);
                    w+=truck[i];
                    break;
                }else{
                    if(q.size()==bridge_length){
                        w-= q.poll();
                    }
                    if(w+truck[i]<=weight){
                        q.add(truck[i]);
                        w+=truck[i];
                        break;
                    }else{
                        q.add(0);
                    }
                }
            }
        }
        return answer+ bridge_length;
    }
}