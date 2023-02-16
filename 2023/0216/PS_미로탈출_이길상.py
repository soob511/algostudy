# https://school.programmers.co.kr/learn/courses/30/lessons/159993

from queue import Queue

def solution(maps):
    X = len(maps)
    Y = len(maps[0])
    
    for x in range(X):
        for y in range(Y):
            if maps[x][y] == 'S':
                start = [x, y]
                
    # 
    delta = [[0,1],[0,-1],[1,0],[-1,0]]
    answer = -1
    
    # start to lever
    Q = Queue()
    Q.put([start[0], start[1], 0])
    visited = [[False for ch in line] for line in maps]
    visited[start[0]][start[1]] = True
    
    while not Q.empty():
        x, y, t = Q.get()
        
        for dx, dy in delta:
            nx = x+dx
            ny = y+dy
            
            if nx<0 or ny<0 or nx>=X or ny>=Y:
                continue
            if maps[nx][ny] == 'X' or visited[nx][ny]:
                continue
            if maps[nx][ny] == 'L':
                answer = t+1
                Q = Queue()
                break
            
            visited[nx][ny] = True
            Q.put([nx, ny, t+1])
    
    # lever to exit
    Q.put([nx, ny, 0])
    visited = [[False for ch in line] for line in maps]
    visited[nx][ny] = True
    
    while not Q.empty():
        x, y, t = Q.get()
        
        for dx, dy in delta:
            nx = x+dx
            ny = y+dy
            
            if nx<0 or ny<0 or nx>=X or ny>=Y:
                continue
            if maps[nx][ny] == 'X' or visited[nx][ny]:
                continue
            if maps[nx][ny] == 'E':
                answer += t+1
                return answer
            
            visited[nx][ny] = True
            Q.put([nx, ny, t+1])
        
    return -1
