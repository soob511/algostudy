# https://school.programmers.co.kr/learn/courses/30/lessons/12902#

def solution(n):
    BIGINT = 1_000_000_007
    
    if n%2 == 1:
        return 0
    DP = [[0,0,0] for _ in range(n+1)]
    DP[0][0] = 1
    DP[1][2] = 2
    
    for i in range(2, n+1):
        DP[i][0] = (DP[i-2][0] + DP[i-1][2]) % BIGINT
        DP[i][1] = (DP[i-1][2]) % BIGINT
        DP[i][2] = (DP[i-1][0]*2 + DP[i-1][1]) % BIGINT

    return DP[n][0]
