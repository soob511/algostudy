# https://school.programmers.co.kr/learn/courses/30/lessons/250136

DELTA = ((0, 1), (1, 0), (-1, 0), (0, -1))

def bfs(land, visited, x, y):
    queue = [(x, y)]
    visited[x][y] = True
    
    X, Y = len(land), len(land[0])
    low, high, count = y, y, 1
    
    while queue:
        temp = []
        for x, y in queue:
            for dx, dy in DELTA:
                nx, ny = x+dx, y+dy
                
                if nx<0 or ny<0 or nx >= X or ny >= Y:
                    continue
                if visited[nx][ny] or land[nx][ny] == 0:
                    continue
                
                visited[nx][ny] = True
                temp.append((nx, ny))
                
                high = max(high, ny)
                low = min(low, ny)
                count += 1
                
        queue = temp
    
    return low, high, count

def solution(land):
    X, Y = len(land), len(land[0])
    visited = [[False for _ in range(Y)] for _ in range(X)]
    ranges = []
    
    for x in range(X):
        for y in range(Y):
            if land[x][y] and not visited[x][y]:
                ranges.append(bfs(land, visited, x, y))
                
    sums = [0 for _ in range(Y)]
    
    for low, high, value in ranges:
        for i in range(low, high + 1):
            sums[i] += value
    
    answer = max(sums)
    
    return answer
