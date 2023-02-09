import java.util.*;
class Solution {
    public int[] solution(int[] answers) {

        int[]a = {1,2,3,4,5};
        int[]b = {2,1,2,3,2,4,2,5};
        int[]c = {3,3,1,1,2,2,4,4,5,5};

        int ans1 = 0, ans2 = 0, ans3 = 0;

        for(int i=0; i<answers.length; i++) {
            if(answers[i]==a[i%5]) ans1++;
            if(answers[i]==b[i%8]) ans2++;
            if(answers[i]==c[i%10]) ans3++;
        }
        int max = Math.max(ans1, Math.max(ans2, ans3));

        List<Integer> arr = new ArrayList<>();
        if(max==ans1) arr.add(1);
        if(max==ans2) arr.add(2);
        if(max==ans3) arr.add(3);

        int[] res = new int[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            res[i] = arr.get(i);
        }

        return res;
    }
}