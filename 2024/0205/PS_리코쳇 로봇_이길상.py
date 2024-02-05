# https://school.programmers.co.kr/learn/courses/30/lessons/169199

def solution(board):
    X = len(board)
    Y = len(board[0])
    INF = X*Y
    DELTA = ((1,0), (0,1), (-1,0), (0,-1))
    queue = []
    moves = [[INF for x in range(Y)] for x in range(X)]
    
    # 시작점 찾아서 큐에 넣기
    for x in range(X):
        for y in range(Y):
            if board[x][y] == 'R':
                queue = [(x, y)]
    
    # 단계마다 큐 순회하며 다음 큐 생성
    for step in range(1, INF):
        points = []
        for x, y in queue:
            for dx, dy in DELTA:
                # 상하좌우로 미끄러졌을때의 위치 계산
                nx, ny = x+dx, y+dy
                while nx>=0 and nx<X and ny>=0 and ny<Y and board[nx][ny] != 'D':
                    nx += dx
                    ny += dy
                nx -= dx
                ny -= dy
                
                # 이전에 방문했던 곳이면 continue
                if step > moves[nx][ny]:
                    continue
                    
                # 목표지점이면 return
                if board[nx][ny] == 'G':
                    return step
                
                # 처음 도달한 곳이면 단계 기록하고 큐에 저장
                moves[nx][ny] = step
                points.append((nx, ny))
        # 더 갈수있는 곳이 없으면 break
        queue = points
        if not queue:
            break

    # 도달할 수 있는 지점 중 목표점이 없으면 -1 return
    return -1
