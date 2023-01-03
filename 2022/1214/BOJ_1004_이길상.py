import sys
from queue import PriorityQueue
sys.setrecursionlimit(100000)

input = sys.stdin.readline
write = sys.stdout.write

for t in range(int(input())):
    x1, y1, x2, y2 = map(int, input().split())

    N = int(input())

    answer = 0

    for n in range(N):
        x, y, r =  map(int, input().split())

        start = (x-x1)**2 + (y-y1)**2 <= r**2
        end = (x-x2)**2 + (y-y2)**2 <= r**2

        if start^end:
            answer += 1
    
    print (answer)
