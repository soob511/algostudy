N = int(input())
WEIGHTS = list(map(int, input().split()))
WEIGHTS.sort()

limit = 0

for w in WEIGHTS:
    if limit + 1 < w:
        print(limit+1)
        exit(0)
    
    limit += w

print(limit + 1)
