def solution(n):
    
    answer = []
    maxx = 0
    for i in range(n):
        answer.append([0]*(i+1))
        maxx+=(i+1)
    
    dr = [1,0,-1]
    dc = [0,1,-1]
    
    m = 1
    x = 0
    y = 0
    dirs = 0
    
    while m<=maxx:
        
        answer[x][y]=m
        
        nx=x+dr[dirs]
        ny=y+dc[dirs]
        
        if nx<0 or nx>=n or ny<0 or ny>=n or answer[nx][ny]>0:
            dirs=(dirs+1)%3
            nx =x+dr[dirs]
            ny =y+dc[dirs]   
        
        m+=1
        x=nx
        y=ny
        
    ans = []
    for i in range(n):
        for j in range(i+1):
            ans.append(answer[i][j])
            
            
    return ans
