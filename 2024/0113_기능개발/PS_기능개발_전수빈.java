import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int total = 0;
        int num = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while(total!=n){
            int count = 0;
            for(int i=0;i<n;i++){
                if(progresses[i]<100){
                    progresses[i]+=speeds[i];
                }
            }
            if(progresses[num]>=100){
                for(int i=num;i<n;i++){
                    if(progresses[num]>=100){
                        count++;
                        num = i+1;
                    }else{
                        break;
                    }    
                }
            }
            if(count!=0){
             list.add(count);   
            }
            total+=count;
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }  
        return answer;
    }
}