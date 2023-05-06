N, M = map(int, input().split())

L = list(map(int, input().split()))

P = [0]
N = [0]

for num in L:
    if num>0:
        P.append(num)
    else:
        N.append(-num)

P.sort()
N.sort()

answer = -max(P[-1], N[-1])

for i in range(len(P)-1, -1, -M):
    answer += (P[i]*2)


for i in range(len(N)-1, -1, -M):
    answer += (N[i]*2)

print(answer)
