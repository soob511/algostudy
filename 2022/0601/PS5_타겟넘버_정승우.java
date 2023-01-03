class Solution {
    int cnt = 0;
    private void rec(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target)
                cnt++;
            return;
        }
        rec(numbers, target, idx+1, sum+numbers[idx]);
        rec(numbers, target, idx+1, sum-numbers[idx]);
    }
    
    
    public int solution(int[] numbers, int target) {
        rec(numbers, target, 0, 0);
        return cnt;
    }
}