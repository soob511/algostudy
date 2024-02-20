import heapq
INF = int(1e9)

def solution(N, road, K):
    
    llist = dict()
    for i in range(1,N+1):
        llist[i] = []
    
    for i in road:
        llist[i[0]].append([i[1],i[2]])
        llist[i[1]].append([i[0],i[2]])
        
    
    # visited = [False]*(N+1)
    dist = [INF]*(N+1)
    
    dist[1]=0
    
    curr = None
    
    # 1. dijkstra(직접 최단 경로 찾기)  
#     for _ in range(N):
        
#         # 가장 dist가 작은 다음 노드 탐색
#         min_idx = -1
#         min_dist = INF
#         for i in range(1,N+1):
#             if not visited[i] and dist[i]<min_dist:
#                 min_dist = dist[i]
#                 min_idx = i
        
#         curr = min_idx
#         visited[curr]=True
        
#         # 가장 거리가 가까운 마을에서 더 가까운 마을 경로로 갱신
#         for n, d in llist[curr]:
#             if dist[curr]+d < dist[n]:
#                 dist[n] = dist[curr]+d
    q = []
    heapq.heappush(q,(0,1))
    
    while q:
        d, curr = heapq.heappop(q)
        if dist[curr]<d:
            continue
        # 가장 거리가 가까운 마을에서 더 가까운 마을 경로로 갱신
        for n, d in llist[curr]:
            if dist[curr]+d < dist[n]:
                dist[n] = dist[curr]+d
                heapq.heappush(q,(dist[n],n))
        
    
    answer = 0
    for i in dist:
        answer += (1 if i<=K else 0)
        
    return answer
    
