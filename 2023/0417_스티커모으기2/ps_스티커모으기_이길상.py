# https://school.programmers.co.kr/learn/courses/30/lessons/12971

def solution(sticker):
    N = len(sticker)
    
    if N == 1:
        return sticker[0]
    
    DP = [[0 for _ in range(N)] for _ in range(2)]
    
    DP[0][0] = sticker[0]
    DP[1][1] = sticker[1]
    
    for i in range(2):
        for j in range(i+1, N):
            DP[i][j] = max(DP[i][j-2] + sticker[j], DP[i][j-1])
    
    return max(DP[0][N-2], DP[1][N-1])
