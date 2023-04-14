def solution(key, lock):
    
    M = len(key)
    N = len(lock)
    
    L = 2*M+N-2
    X = M+N-1
    
    key2 = [[0 for _ in range(M)] for _ in range(M)]    
    x=0
    for j in range(M-1,-1,-1):
        y=0
        for i in range(M):
            key2[x][y]=key[i][j]
            y+=1
        x+=1
        
    key3 = [[0 for _ in range(M)] for _ in range(M)]    
    x=0
    for j in range(M-1,-1,-1):
        y=0
        for i in range(M):
            key3[x][y]=key2[i][j]
            y+=1
        x+=1
    
    key4 = [[0 for _ in range(M)] for _ in range(M)]    
    x=0
    for j in range(M-1,-1,-1):
        y=0
        for i in range(M):
            key4[x][y]=key3[i][j]
            y+=1
        x+=1
        
    keys = [key,key2,key3,key4]


    
    
    for i in range(X):
        for j in range(X):
            
            for k in range(4):
                
                currKey = keys[k]
                
                # 지도에 자물쇠 세팅
                maps1 = [[0 for _ in range(L)] for _ in range(L)]
                for a in range(M-1,M-1+N):
                    for b in range(M-1,M-1+N):
                        maps1[a][b]=lock[a-(M-1)][b-(M-1)]
                
                # 지도에 열쇠 배치
                maps2 = [[0 for _ in range(L)] for _ in range(L)]
                for c in range(i,i+M):
                    for d in range(j,j+M):
                        maps2[c][d]=currKey[c-i][d-j]
                        
                # 자물쇠와 열쇠가 맞는지 확인
                fit=True
                for a in range(M-1,M-1+N):
                    for b in range(M-1,M-1+N):
                        if maps1[a][b]==maps2[a][b]:
                            fit=False
                            break
                    if not fit:
                        break
                        
                if fit:
                    return True # 열수 있으면 True

    return False # 열수 없으면 False
