def solution(n, results):
    
    map = [[0 for _ in range(n+1)] for _ in range(n+1)]
    
    for a,b in results:
        map[a][b]=1
        map[b][a]=-1
        
    for k in range(1,n+1):
        for i in range(1,n+1):
            for j in range(1,n+1):
                if map[i][k]==1 and map[k][j]==1:
                    map[i][j]=1
                    map[j][i]=-1
                if map[i][k]==-1 and map[k][j]==-1:
                    map[i][j]=-1
                    map[j][i]=1
    ans=0
    for i in range(1,n+1):
        cnt=0
        for j in range(1,n+1):
            if map[i][j]==0:
                cnt+=1
        if cnt==1:
            ans+=1
    
    return ans
