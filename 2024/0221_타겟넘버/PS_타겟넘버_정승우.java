class Solution {
    int cnt = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, target, 0, 0);

        answer = cnt;

        return answer;
    }
    public void dfs(int[] numbers, int target, int idx, int res){
        if (idx == numbers.length){
            if (target == res){
                cnt++;
            }
            return;
        }

        dfs(numbers, target, idx+1, res + numbers[idx]);
        dfs(numbers, target, idx+1, res - numbers[idx]);


    }

}