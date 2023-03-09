class Solution {
    static int num[];
    static int n;
    static int res[] = new int[3];
    static int cnt = 0;

    public int solution(int[] number) {
        int answer = 0;
        n = number.length;
        num = number;
        dfs(0,0);
        return cnt;
    }

    private static void dfs(int idx, int depth) {
        if(depth==3) {
            int sum = 0;
            for(int i=0; i<3; i++) {
                sum = sum + res[i];
            }
            if(sum==0) {
                cnt++;
            }
            return;
        }

        for(int i=idx; i<n; i++) {
            res[depth] = num[i];
            dfs(i+1, depth+1);
        }
    }
}