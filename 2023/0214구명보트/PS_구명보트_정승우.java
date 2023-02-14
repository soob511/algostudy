import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lt = 0;
        int rt = people.length-1;

        while(true) {
            if(lt>rt) {
                break;
            }
            if(lt==rt) {
                answer++;
                break;
            }
            if(people[lt]+people[rt]>limit) {
                answer++;
                rt--;
            }else if (people[lt]+people[rt]<=limit) {
                answer++;
                lt++;
                rt--;
            }

        }



        return answer;

    }


}