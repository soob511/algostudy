from queue import Queue

# 농장 크기
N, M = map(int, input().split())

# 농장 정보
FARM = [list(map(int,input().split())) for n in range(N)]

# 방문 체크용 배열
visited = [[False for _ in range(M)] for n in range(N)]

# 정답 카운트
answer = 0

for n in range(N):
    for m in range(M):
        if visited[n][m]: continue

        # 산봉우리 확인용 변수
        peak = True

        # BFS로 같은 높이의 인접 영역 탐색
        queue = Queue()
        queue.put((n, m))
        visited[n][m] = True

        while not queue.empty():
            x, y = queue.get()

            for nx in range(x-1, x+2):
                for ny in range(y-1, y+2):
                    if nx<0 or ny<0 or nx>=N or ny>=M: continue
                    if FARM[nx][ny] != FARM[x][y]:
                        # 주변 탐색 중 더 높은 곳이 있으면 산봉우리 아님
                        if FARM[nx][ny] > FARM[x][y]:
                            peak = False
                        continue
                    if visited[nx][ny]: continue

                    queue.put((nx, ny))
                    visited[nx][ny] = True
        
        # 산봉우리가 맞으면 정답 +1
        if peak:
            answer += 1

print(answer)
