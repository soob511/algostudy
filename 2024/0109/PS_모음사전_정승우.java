import java.util.*;
class Solution {
    static String[] words = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        dfs("",0);

        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    void dfs(String str, int cnt) {

        list.add(str);

        if(cnt==5) {
            return;
        }

        for (int i=0; i<5; i++) {
            dfs(str + words[i], cnt+1);
        }

    }

}