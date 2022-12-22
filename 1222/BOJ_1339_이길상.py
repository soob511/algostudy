D = dict()

N = int(input())
for n in range(N):
    word = input()
    mount = 10**(len(word)-1)
    for ch in word:
        if ch not in D:
            D[ch] = 0
        D[ch] += mount
        mount//=10

V = sorted(list(D.values()))
answer = 0
val = 9 - len(V)
for v in V:
    val+=1
    answer += (val*v)

print(answer)
