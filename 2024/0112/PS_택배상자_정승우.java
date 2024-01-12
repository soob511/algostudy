import java.util.*;
class Solution {
    public int solution(int[] order) {
        //컨테이너 벨트
        Stack<Integer> stack = new Stack<>();


        int answer = 0;
        int idx = 0;
        for(int i=1; i<=order.length; i++) {
            if(order[idx]==i) {
                answer++;
                idx++;
            } else {
                stack.push(i);
            }

            while(!stack.isEmpty() && stack.peek() == order[idx]) {

                stack.pop();
                idx++;
                answer++;
            }
        }



        return answer;
    }
}