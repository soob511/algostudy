N = int(input())
DP = [0 for _ in range(N+2)]
DP[0] = DP[1] = 1

for n in range(2, N+1):
    DP[n] = (DP[n-1] + 2*DP[n-2]) % 10007
    
print(DP[N])
