import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 투 포인터
        int low = 0, high = people.length - 1;
        
        // 정렬
        Arrays.sort(people);
        
        // 보트 시뮬레이션
        while(low < high){
            // 2명
            if(people[low] + people[high] <= limit){
                low++;
                high--;
            }
            // 1명
            else{
                high--;
            }
            answer++;
        }
        
        if(low == high)
            answer++;
        
        return answer;
    }
}
