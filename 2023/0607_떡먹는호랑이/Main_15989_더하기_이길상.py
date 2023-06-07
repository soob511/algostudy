DP = [[0,0,0] for _ in range(10001)]

# [전체, 1을 쓰지 않은 것, 1과 2를 쓰지 않은 것]
DP[1] = [1, 0, 0] 
DP[2] = [2, 1, 0]
DP[3] = [3, 1, 1]
                   

for n in range(4, 10001):
    DP[n][0] = DP[n-1][0] + DP[n-2][1] + DP[n-3][2]
    DP[n][1] = DP[n-2][1] + DP[n-3][2]
    DP[n][2] = DP[n-3][2]
    

T = int(input())

for _ in range(T):
    N = int(input())
    print(DP[N][0])
