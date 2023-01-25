N = int(input())
DP = [0 for _ in range(1001)]

for a in map(int, input().split()):
    DP[a] = max(DP[a], )
    for i in range(1, a):
        if DP[i] != 0:
            DP[a] = max(DP[a], DP[i] + a)

print(max(DP))
