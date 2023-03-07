import heapq

N = int(input())
LIST = [list(map(int, input().split())) for _ in range(N)]

LIST.sort()
CLASS = []

for S, T in LIST:
    if CLASS and CLASS[0] <= S:
        heapq.heappop(CLASS)
    heapq.heappush(CLASS, T)

print(len(CLASS))
