import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n>s){
            return new int[]{-1};
        }else{
            for(int i=0;i<answer.length;i++){
                answer[i] = s/n;
            }
            for(int i=0;i<s%n;i++){
                answer[i]++;
            }
            Arrays.sort(answer);
        }
    
        return answer;
    }
}