# https://school.programmers.co.kr/learn/courses/30/lessons/12978

def solution(N, road, K):
    # 포인트간 최단거리
    roads = [[0 for _ in range(N)] for _ in range(N)]
    for a, b, t in road:
        if roads[a-1][b-1] == 0 or roads[a-1][b-1] > t:
            roads[a-1][b-1] = roads[b-1][a-1] = t
    
    # 1번과의 최단거리
    dist = [0 for _ in range(N)]
    
    # 1번과 직접 이어진 포인트부터 시작
    points = []
    for i in range(1, N):
        if roads[0][i] > 0:
            points.append(i)
            dist[i] = roads[0][i]
    
    # 단계별로 다음 포인트들 확인
    while points:
        temp = []
        # 포인트를 순회하며
        for p in points:
            # 다른 포인트에 대해서
            for i in range(1, N):
                # 직접 이동 가능하면
                if roads[p][i] > 0:
                    # 최단거리 갱신
                    if dist[i] == 0 or dist[i] > dist[p] + roads[p][i]:
                        dist[i] = dist[p] + roads[p][i]
                        temp.append(i)
        points = temp

            
    return sum([1 if d <= K else 0 for d in dist])
