import heapq

N, M = map(int, input().split())

A = list(map(int, input().split()))

PQ = []

for num in A:
    heapq.heappush(PQ, num)

for m in range(M):
    x = heapq.heappop(PQ)
    y = heapq.heappop(PQ)

    z = x+y
    heapq.heappush(PQ, z)
    heapq.heappush(PQ, z)

print(sum(PQ))
