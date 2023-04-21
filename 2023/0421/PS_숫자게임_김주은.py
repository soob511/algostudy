def solution(A, B):
    
    A.sort()
    B.sort()
    
    l = len(B)
    
    cnt=0
    
    idx = 0
    for a in A:
        while a>=B[idx]:
            idx+=1
            if idx==l:
                return cnt
        
        cnt+=1
        idx+=1
        if idx==l:
            break
        
    return cnt
    
        
