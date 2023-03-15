import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};

        if(s<n) {
            answer = new int[] {-1};
            return answer;

        }

        if(s%n==0) {
            int a = s/n;
            answer = new int[n];
            for(int i=0; i<n; i++) {
                answer[i] = a;
            }

        } else {
            //일단 채울 값
            int a = s/n;
            //나머지 (뒤에서부터 1씩 채움)
            int b = s%n;

            answer = new int[n];

            for(int i=0; i<n; i++) {
                answer[i] = a;
            }

            for(int i=n-b; i<n; i++) {
                answer[i] += 1;
            }


        }

        return answer;




    }
}