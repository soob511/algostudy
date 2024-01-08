class Solution {
    public int[] solution(int n, long left, long right) {

        int[] answer = new int[(int)(right-left)+1];


        for(int i=0; i<answer.length; i++) {
            int row = (int) ((i+left)/n)+1;
            int col = (int) ((i+left)%n)+1;

            int max = Math.max(row,col);
            answer[i] = max;


        }


        return answer;
    }
}