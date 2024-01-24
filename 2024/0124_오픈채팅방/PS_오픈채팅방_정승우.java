import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();

        for (int i=0; i<record.length; i++) {
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter")) {
                arr.add(str[1]+"님이 들어왔습니다.");
                map.put(str[1], str[2]);
            } else if (str[0].equals("Leave")) {
                arr.add(str[1]+"님이 나갔습니다.");
            } else {
                map.put(str[1], str[2]);
            }
        }

        answer = new String[arr.size()];

        for(int i=0; i<arr.size(); i++) {
            int idx = arr.get(i).indexOf("님");
            String tmp = arr.get(i).substring(0, idx);
            String s = map.get(tmp);
            String res = s + arr.get(i).substring(idx);
            answer[i] = res;

        }

        return answer;
    }
}