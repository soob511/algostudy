import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i=0;i<discount.length-9;i++){
            HashMap<String,Integer> hash = new HashMap<>();
            for(int j=i;j<i+10;j++){
               if(!hash.containsKey(discount[j])){
                     hash.put(discount[j],1);
               }else{
                    hash.put(discount[j],hash.get(discount[j])+1);
               }
            }
            boolean pass = true;
            for(int j=0;j<want.length;j++){
                if(!hash.containsKey(want[j])||hash.get(want[j])<number[j]){
                    pass = false;
                    break;
                }
            }
            if(pass)answer++;
        }
        return answer;
    }
}