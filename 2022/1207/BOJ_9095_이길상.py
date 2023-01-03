import sys
sys.setrecursionlimit(100000)

T = int(input())

DP = [0 for _ in range(12)]
DP[0] = 1
DP[1] = 1
DP[2] = 2

for n in range(3,12):
    DP[n] = DP[n-1]+DP[n-2]+DP[n-3]

for t in range(T):
    N = int(input())
    print(DP[N])
