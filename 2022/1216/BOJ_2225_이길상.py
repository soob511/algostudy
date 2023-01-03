import sys
sys.setrecursionlimit(100000)

N, K = map(int, input().split())
DP = [[0 for __ in range(K+1)] for _ in range(N+1)]

def suse(n, k):
    if k == 1:
        return 1

    if DP[n][k] == 0:
        for i in range(n+1):
            DP[n][k] += suse(n-i, k-1)
            DP[n][k] %= 1_000_000_000
    
    return DP[n][k]

print(suse(N, K))
