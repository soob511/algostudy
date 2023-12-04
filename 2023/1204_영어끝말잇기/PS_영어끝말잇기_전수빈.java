import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        HashMap<String,Integer> map = new HashMap<>();
        map.put(words[0],0);
        for(int i=1;i<words.length;i++){
            String b = words[i-1];
            String c = words[i];
            char end = b.charAt(b.length()-1);
            char first = c.charAt(0);
            if(map.containsKey(words[i])||end!=first){
                answer[0] = (i%n+1);
                answer[1] = (i/n+1);
                break;
            }
            map.put(words[i],(i/n+1));
        }
        
        
        return answer;
    }
}