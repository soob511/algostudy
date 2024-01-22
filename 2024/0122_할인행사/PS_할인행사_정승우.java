import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int cnt = 0;
        int size = want.length;
        for(int i=0; i<number.length; i++) {
            cnt += number[i];
        }

        for(int i=0; i<cnt; i++) {
            for(int j=0; j<size; j++) {
                if(discount[i].equals(want[j])) number[j]--;
            }
        }
        boolean check = all_Check(number, size);
        if(!check) {
            answer++;
        }

        int idx = 0;
        for(int i=cnt; i<discount.length; i++) {
            for(int j=0; j<size; j++) {
                if(discount[i].equals(want[j])) number[j]--;
            }

            for(int j=0; j<size; j++) {
                if(discount[idx].equals(want[j])) number[j]++;
            }
            idx++;

            check = all_Check(number, size);
            if(!check) {
                answer++;
            }
        }


        return answer;
    }

    boolean all_Check(int[] number, int size) {
        boolean check = false;
        for(int j=0; j<size; j++) {
            if(number[j] > 0) {
                check = true;
                break;
            } else {
                check = false;
            }
        }
        return check;
    }
}