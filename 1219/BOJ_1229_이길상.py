import sys
sys.setrecursionlimit(100000)

N = int(input())

# hexnum n = sigma(1,n){ 4n - 3 )} = 4*(n(n+1)/2) - 3n = 2*n*n - n

DP = [1_000_001 for _ in range(N+1)]
DP[0] = 0

HEXNUM = [1]
n = 1
hexnum = 1
while hexnum <= N:
    HEXNUM.append(hexnum)
    hexnum = hexnum + 4*n + 1
    n+=1

for num in range(1,N+1):
    for hexnum in HEXNUM:
        if hexnum > num:
            break
        DP[num] = min(DP[num], DP[num-hexnum])
    
    DP[num]+=1

print(DP[N])

