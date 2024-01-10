import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        int len = truck_weights.length;
        int sum_weights = 0;
        int idx = 0;

        while(true){

            if (idx == len) break;

            //다리가 트럭으로 다찼으면
            if(q.size() == bridge_length) {
                sum_weights -= q.poll();
            }

            //다리 위의 트럭 무게가 무게 제한을 넘으면
            else if(sum_weights + truck_weights[idx] > weight) {
                q.add(0);
                answer++;

            }

            //트럭 추가
            else {
                q.add(truck_weights[idx]);
                sum_weights += truck_weights[idx];
                System.out.println(sum_weights);
                answer++;
                idx++;
            }
        }


        System.out.println(q);


        return answer + bridge_length;
    }
}