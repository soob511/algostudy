import sys
from queue import PriorityQueue
sys.setrecursionlimit(100000)

N = int(input())

ROAD = list(map(int,input().split()))

PRICE = list(map(int,input().split()))

cur = PRICE[0]
sum = 0
answer = 0

for n in range(N-1):
    sum += ROAD[n]
    if PRICE[n+1] < cur:
        answer += (sum*cur)
        sum = 0
        cur = PRICE[n+1]

answer += (sum*cur)

print(answer)
