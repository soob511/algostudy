import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;


        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            String type = clothes[i][1];

            System.out.println(type);
            if(map.get(type) == null) {
                map.put(type, 1);
            } else {
                map.put(type, map.get(type) + 1);
            }
        }

        for(String str : map.keySet()) {
            int tmp = map.get(str);
            //0도 포함이라 +1
            tmp++;
            answer = answer * tmp;
        }

        //최소 한가지는 입기 때문에 -1
        answer--;


        return answer;
    }
}