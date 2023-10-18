class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        int res = 0;

        while(n > 0){
            res = n % 3;
            n /= 3;
            if(res == 0) {
                res = 4;
                n -= 1;
            }
            sb.append(res);
        }
        return sb.reverse().toString();
    }
}
