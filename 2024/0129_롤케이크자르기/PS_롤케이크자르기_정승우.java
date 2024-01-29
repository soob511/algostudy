import java.util.*;

class Solution {
    public int solution(int[] topping) {

        int answer = 0;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int idx : topping) {
            map2.put(idx, map2.getOrDefault(idx, 0) + 1);
        }



        for (int idx : topping) {
            map1.put(idx, map1.getOrDefault(idx, 0) + 1);

            if (map2.get(idx) - 1 == 0) {
                map2.remove(idx);
            } else {
                map2.put(idx, map2.get(idx) - 1);
            }
            if (map1.size() == map2.size()) {
                answer++;
            }
        }

        return answer;
    }
}