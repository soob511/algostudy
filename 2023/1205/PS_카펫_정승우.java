import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int res = brown + yellow;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=res/2; i>0; i--) {
            if(res%i==0) {
                map.put(i,res/i);
            }
        }


        //i의 범위 12   6 


        for(int i=0; i<res; i++) {
            //키값이 있다면
            if(map.containsKey(i)) {
                int k = i;
                int v = map.get(k);

                if(k<3||v<3||k<v||(k-2)*(v-2)!=yellow) {
                    map.remove(i);
                }
            } else {
                continue;
            }
        }

        int k = 0;
        for(int key : map.keySet()) {
            k = key;
        }
        int v =  map.get(k);

        answer[0] = k;
        answer[1] = v;

        return answer;
    }
}