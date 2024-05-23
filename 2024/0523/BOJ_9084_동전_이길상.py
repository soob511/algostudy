T = int(input())

for t in range(T):
    N = int(input())
    COINS = list(map(int, input().split()))
    M = int(input())

    DP = [0] * (M+1)
    DP[0] = 1
    for cost in COINS:
        for i in range(M-cost+1):
            if DP[i] == 0:
                continue
            DP[i+cost] += DP[i]

    print(DP[M])
