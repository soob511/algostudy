N, L = map(int, input().split())
MAP = [list(map(int, input().split())) for _ in range(N)]


answer = 0

for x in range(N):
    value = MAP[x][0]
    count = 0
    for y in range(N):
        if MAP[x][y] == value:
            count+=1
        elif MAP[x][y] == value + 1:
            if count < L:
                count = -1
                break
            count = 1
        elif MAP[x][y] == value - 1:
            if count < 0:
                count = -1
                break
            count = -L+1
        else:
            count = -1
            break
        value = MAP[x][y]
    if count >= 0:
        answer += 1

for y in range(N):
    value = MAP[0][y]
    count = 0
    for x in range(N):
        if MAP[x][y] == value:
            count+=1
        elif MAP[x][y] == value + 1:
            if count < L:
                count = -1
                break
            count = 1
        elif MAP[x][y] == value - 1:
            if count < 0:
                count = -1
                break
            count = -L+1
        else:
            count = -1
            break
        value = MAP[x][y]
    if count >= 0:
        answer += 1

print(answer)
