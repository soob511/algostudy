N = int(input())
LINE = input()

MTX = [[0 for _ in range(N)] for _ in range(N)]
SUM = [[0 for _ in range(N)] for _ in range(N)]

idx = 0
for i in range(N):
    for j in range(i,N):
        if LINE[idx] == '+':
            MTX[i][j] = 1
        elif LINE[idx] == '-':
            MTX[i][j] = -1
        
        idx+=1


def guess(n):
    if n==N:
        for i in range(N):
            print(SUM[i][i], end=' ')
        exit(0)
    for num in range(-10, 11):
        S = True

        for i in range(n+1):
            if n==0:
                SUM[i][n] = num
            else:
                SUM[i][n] = SUM[i][n-1] + num
            if SUM[i][n]==0 and MTX[i][n] == 0:
                continue
            elif SUM[i][n]*MTX[i][n] > 0:
                continue
            S = False
            break

        if S:
            guess(n+1)

guess(0)
