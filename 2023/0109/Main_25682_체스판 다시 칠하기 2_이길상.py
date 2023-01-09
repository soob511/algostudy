N, M, K = map(int,input().split())

BOARD = [input() for _ in range(N)]
DP = [[[0, 0] for m in range(M+1)] for n in range(N+1)]

for n in range(1, N+1):
    for m in range(1, M+1):
        
        if BOARD[n-1][m-1] == 'W':
            DP[n][m][0] = 1 - (n+m)%2
            DP[n][m][1] = (n+m)%2
        else:
            DP[n][m][0] = (n+m)%2
            DP[n][m][1] = 1 - (n+m)%2
        
        if n>0 and m>0:
            DP[n][m][0] += (DP[n][m-1][0] + DP[n-1][m][0] - DP[n-1][m-1][0])
            DP[n][m][1] += (DP[n][m-1][1] + DP[n-1][m][1] - DP[n-1][m-1][1])

answer = K*K

for n in range(K, N+1):
    for m in range(K, M+1):
        answer = min(answer, DP[n][m][0] - DP[n-K][m][0] - DP[n][m-K][0] + DP[n-K][m-K][0])
        answer = min(answer, DP[n][m][1] - DP[n-K][m][1] - DP[n][m-K][1] + DP[n-K][m-K][1])

print(answer)
