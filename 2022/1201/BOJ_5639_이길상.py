import sys
from queue import PriorityQueue
sys.setrecursionlimit(100000)

input = sys.stdin.readline
write = sys.stdout.write

PRE = []

while True:
    try:
        PRE.append(int(input()))
    except:
        break

def order(lo, hi):
    if lo > hi: return

    mid = hi+1
    for i in range(lo+1, hi+1):
        if PRE[lo] < PRE[i]:
            mid = i
            break
    
    order(lo+1, mid-1)
    order(mid, hi)
    print(PRE[lo])

order(0, len(PRE)-1)
