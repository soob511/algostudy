import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> hash = new HashMap<>();
        int count = 0;
        for(int i=0;i<record.length;i++){
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")){
                count++;
                if(!hash.containsKey(s[1])){
                    hash.put(s[1],s[2]);
                }else{
                    hash.remove(s[1]);
                    hash.put(s[1],s[2]);
                }
            }else if(s[0].equals("Change")){
                 hash.remove(s[1]);
                 hash.put(s[1],s[2]);
            }else{
                count++;
            }
        }
         String[] answer = new String[count];
         int num = 0;
         for(int i=0;i<record.length;i++){
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")){
               answer[num] = hash.get(s[1])+"님이 들어왔습니다.";
               num++;
            }else if(s[0].equals("Leave")){
               answer[num] = hash.get(s[1])+"님이 나갔습니다.";
               num++;
            }
        }
        return answer;
    }
}