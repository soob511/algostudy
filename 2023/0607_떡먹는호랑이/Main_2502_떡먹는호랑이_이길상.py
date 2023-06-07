D, K = map(int, input().split())

AB = [[0,0] for _ in range(D)]

AB[0][0] = 1
AB[1][1] = 1

for i in range(2, D):
    AB[i][0] = AB[i-1][0] + AB[i-2][0]
    AB[i][1] = AB[i-1][1] + AB[i-2][1]

for a in range(1, K//2 + 1):
    bk = (K - a * AB[-1][0])

    if bk % AB[-1][1] == 0:
        b = bk // AB[-1][1]
        print(a)
        print(b)

        break
