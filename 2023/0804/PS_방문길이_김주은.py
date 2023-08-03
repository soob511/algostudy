# https://school.programmers.co.kr/learn/courses/30/lessons/49994

def solution(dirs):
    
    sets = {'U':0, 'R':1, 'D':2, 'L':3}
    
    dr = [-1,0,1,0]
    dc = [0,1,0,-1]
    
    # U R D L
    visited = [[[False for _ in range(11)] for _ in range(11)] for _ in range(4)]
    
    for idx in range(11):
        visited[0][0][idx]=True
        visited[1][idx][10]=True
        visited[2][10][idx]=True
        visited[3][idx][0]=True
        
    x = 5
    y = 5
        
    newroad = 0    
        
    for dir in dirs:

        nx = x+dr[sets[dir]]
        ny = y+dc[sets[dir]]

        if 0<=nx<=10 and 0<=ny<=10:
            if not visited[sets[dir]][x][y] and not visited[(sets[dir]+2)%4][nx][ny]:
                visited[sets[dir]][x][y]=True
                visited[(sets[dir]+2)%4][nx][ny]=True
                newroad+=1
            x = nx
            y = ny
            
    return newroad
            
            
            
            
