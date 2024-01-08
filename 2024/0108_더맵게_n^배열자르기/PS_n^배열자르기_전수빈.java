class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right - (int)left+ 1];
        
        for(long i = left;i<=right;i++){
            long x = i/n;
            long y = i%n;
            answer[(int)i-(int)left] = Math.max((int)x,(int)y)+1;
        }
        
        return answer;
    }
}