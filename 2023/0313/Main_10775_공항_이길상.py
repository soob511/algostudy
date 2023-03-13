G = int(input())
P = int(input())

RANGES = [i for i in range(G+1)]

for p in range(P):
    g = int(input())
    target = g
    while RANGES[target]!=target:
        target = RANGES[target]

    if target == 0:
        print(p)
        exit(0)

    value = RANGES[target-1]
    RANGES[g] = RANGES[target] = value

print(P)
