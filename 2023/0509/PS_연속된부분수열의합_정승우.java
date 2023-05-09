import java.util.Arrays;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int lt = 0;
        int rt = 0;
        int sum = 0;
        int len = 1000001;

        while (true) {
            if (sum >= k) {
                sum -= sequence[lt];
                lt++;
            }
            else if (rt >= sequence.length) break;
            else if (sum < k) {
                sum += sequence[rt];
                rt++;
            }

            if (sum == k) {
                if (rt - lt < len) {
                    answer[0] = lt;
                    answer[1] = rt-1;
                    len = rt-lt;
                }
            }
        }

        return answer;
    }
}