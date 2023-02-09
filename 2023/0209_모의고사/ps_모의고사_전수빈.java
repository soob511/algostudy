import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int[] score={0,0,0};
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<answers.length;i++){
            if(answers[i]==one[i%5]){
                score[0]++;
            }
            if(answers[i]==two[i%8]){
                score[1]++;
            }
            if(answers[i]==three[i%10]){
                score[2]++;
            }
        }

       int max = Math.max(score[0],Math.max(score[1],score[2]));
        for (int i = 0; i <3; i++) {
            if(max==score[i]){
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i <list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}