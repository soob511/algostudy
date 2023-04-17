class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int length = sticker.length;

        if(length==1) {
            return sticker[0];
        } else if(length==2) {
            return Math.max(sticker[0], sticker[1]);
        }

        int[][]dp = new int[2][length];

        dp[0][0] = sticker[0];
        dp[0][1] = dp[0][0];
        dp[1][0] = 0;
        dp[1][1] = sticker[1];

        for(int i=2; i<length-1; i++) {
            dp[0][i] = Math.max(dp[0][i-2]+sticker[i],dp[0][i-1]);
            dp[1][i] = Math.max(dp[1][i-2]+sticker[i],dp[1][i-1]);
        }

        dp[1][length-1] = Math.max(dp[1][length-3]+sticker[length-1], dp[1][length-2]);
        answer = Math.max(dp[0][length-2], dp[1][length-1]);

        return answer;
    }
}