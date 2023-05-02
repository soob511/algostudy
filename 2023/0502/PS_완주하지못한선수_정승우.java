import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i=0;
        while(i<completion.length) {
            if(!completion[i].equals(participant[i])) {
                break;
            }
            i++;
        }
        return participant[i];
    }
}