import math

MAX = 1003002
def check(n):
    sn = str(n)
    for i in range(0, len(sn)//2):
        if sn[i] != sn[-(i+1)]:
            return False
    return True

NOT_PRIME = set()
NOT_PRIME.add(0)
NOT_PRIME.add(1)

for n in range(math.floor(math.sqrt(MAX))):
    if n in NOT_PRIME:
        continue
    for np in range(n*2, MAX, n):
        NOT_PRIME.add(np)

N = int(input())

for n in range(N, MAX):
    if n in NOT_PRIME:
        continue
    if check(n):
        print(n)
        break
