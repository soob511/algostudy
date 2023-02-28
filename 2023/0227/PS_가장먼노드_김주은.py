import heapq

INF = 200001

def solution(n, edge):
    
    #dijkstra
    global graph, distance
    
    graph = [[] for _ in range(n)]
    
    for a,b in edge:
        graph[a-1].append([b-1,1])
        graph[b-1].append([a-1,1])
    
    distance = [INF for _ in range(n)]

    m = dijkstra(0)
    return distance.count(m)


def dijkstra(start): 
    q = []
    distance[start]=0
    heapq.heappush(q, [start,0])
    
    while q:
        now, dist  = heapq.heappop(q)

        if distance[now]<dist:
            continue
            
        for v, w in graph[now]:
            if dist+w<distance[v]:
                distance[v] = dist+w
                heapq.heappush(q,[v,distance[v]])
    
    return max(distance[:])
        
            
        
        
    
