# https://school.programmers.co.kr/learn/courses/30/lessons/49191

def solution(N, results):
    WL = [[0 for _ in range(N)] for _ in range(N)]
    
    for A, B in results:
        WL[A-1][B-1] = 1
        WL[B-1][A-1] = -1
    
    for i in range(N):
        for x in range(N):
            for y in range(N):
                if WL[x][y] == 0 and WL[x][i]*WL[i][y] == 1:
                    WL[x][y] = WL[x][i]
                    WL[y][x] = -WL[x][y]
    
    answer = 0
    for row in WL:
        if sum(map(abs,row)) == N-1:
            answer += 1
            
    return answer
