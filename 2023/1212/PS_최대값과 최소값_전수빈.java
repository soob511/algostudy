class Solution {
    public String solution(String s) {
        String answer = "";
        String[] num = s.split(" ");
        int min = 1000000;
        int max = -1000000;
        for(int i=0;i<num.length;i++){
            int n = Integer.parseInt(num[i]);
            min = Math.min(min,n);
            max = Math.max(max,n);
        }
        answer = min +" " + max;
        return answer;
    }
}