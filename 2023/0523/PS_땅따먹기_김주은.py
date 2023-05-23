def solution(land):
    
    N = len(land)
    
    dp = [[0 for i in range(4)] for _ in range(N)]
    
    for i in range(4):
        dp[0][i]=land[0][i]
        
    for n in range(1,N):        
        for i in range(4):
            for j in range(4):
                if i==j:
                    continue
                if dp[n][i]<dp[n-1][j]+land[n][i]:
                    dp[n][i]=dp[n-1][j]+land[n][i]
                    
    return max(dp[N-1][:])
