# https://school.programmers.co.kr/learn/courses/30/lessons/131702

dx = [0,0,1,-1]
dy = [1,-1,0,0]

def solution(clocks):
    N = len(clocks)
    answer = N*N*4
    T = 0
    def spin(x, y, t, clocks):
        nonlocal T
        T += t
        
        clocks[x][y]+=t
        clocks[x][y]%=4
        
        for d in range(4):
            nx = x+dx[d]
            ny = y+dy[d]
            if nx<0 or nx>=N or ny<0 or ny>=N:
                continue
            clocks[nx][ny]+=t
            clocks[nx][ny]%=4
    
    
    # 첫줄 결정
    for bitmask in range(1<<(2*N)):
        # 복제
        newclocks = [line[:] for line in clocks]
        T = 0
    
        # 첫줄 회전
        for n in range(N):
            t = bitmask&3
            spin(0, n, t, newclocks)
            bitmask >>= 2
        
        # 나머지 회전
        for x in range(1, N):
            for y in range(N):
                t = (4-newclocks[x-1][y])%4
                spin(x, y, t, newclocks)
        
        # 마지막줄 검사
        if sum(newclocks[-1]) >0:
            continue
        
        # 최소 정답 갱신
        answer = min(answer, T)
    
    return answer
