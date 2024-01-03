import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> q = new LinkedList<Integer>();

        int[] count = new int[progresses.length];

        for(int i = 0; i < count.length; i++) {
            if((100 - progresses[i]) % speeds[i] == 0) {
                count[i] = (100 - progresses[i]) / speeds[i];
            }
            else {
                count[i] = ((100 - progresses[i]) / speeds[i]) + 1;
            }
            q.add(count[i]);
        }

        List<Integer> list = new ArrayList<Integer>();

        int cnt = 0;
        int before = q.peek();

        while(!q.isEmpty()) {

            if(q.peek() <= before) {
                q.poll();
                cnt++;
            }
            else {
                list.add(cnt);
                cnt = 1;
                before = q.poll();
            }
        }
        list.add(cnt);

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}