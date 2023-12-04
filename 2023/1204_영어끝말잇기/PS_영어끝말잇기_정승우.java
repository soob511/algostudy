import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        Set<String> set = new HashSet<String>();


        for(int i=0; i<words.length; i++) {
            if(i!=0) {
                String str = words[i-1];
                String nextStr = words[i];

                char last = str.charAt(str.length() - 1);
                char first = nextStr.charAt(0);

                if(set.contains(nextStr) || first != last) {
                    answer[0] = (i % n)+1;
                    answer[1] = (i / n)+1;

                    return answer;
                }

            }

            set.add(words[i]);

        }

        return answer;

    }
}
