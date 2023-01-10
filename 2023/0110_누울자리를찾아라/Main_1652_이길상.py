N = int(input())
ROOM = [input() for _ in range(N)]

horizontal = vertical = 0

for x in range(N):
    h = v = 0
    for y in range(N):
        if ROOM[x][y] == '.':
            h += 1
        else:
            h = 0
        horizontal += (h == 2)
        
        if ROOM[y][x] == '.':
            v += 1
        else: 
            v = 0
        vertical += (v == 2)

print(horizontal, vertical)
