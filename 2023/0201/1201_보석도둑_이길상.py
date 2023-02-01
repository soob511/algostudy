import sys
import heapq
input = sys.stdin.readline

N, K = map(int, input().split())
jewels = []
for n in range(N):
    M, V = map(int, input().split())
    heapq.heappush(jewels,(M, V))
bags = []
for k in range(K):
    bags.append(int(input()))
bags.sort()

answer = 0
PQ = []
for C in bags:
    while jewels and C >= jewels[0][0]:
        heapq.heappush(PQ, -heapq.heappop(jewels)[1])
    if PQ:
        answer -= heapq.heappop(PQ)
    elif not jewels:
        break
print(answer)
