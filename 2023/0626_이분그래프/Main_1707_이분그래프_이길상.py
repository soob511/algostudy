from collections import deque

K = int(input())

def check(graph, vertex):
    team = [-1 for _ in range(vertex+1)]

    for i in range(1, vertex+1):
        if team[i] != -1:
            continue

        Q = deque()
        team[i] = 0
        Q.append(i)

        while Q:
            u = Q.pop()
            
            for v in graph[u]:
                if team[v] + team[u] == 1:
                    continue
                if team[v] == team[u]:
                    return False

                team[v] = 1 - team[u]
                Q.append(v)
        
    return True

for _ in range(K):
    V, E = map(int, input().split())

    GRAPH = [[] for _ in range(V+1)]

    for _ in range(E):
        u, v = map(int, input().split())
        GRAPH[u].append(v)
        GRAPH[v].append(u)

    if check(GRAPH, V):
        print('YES')
    else:
        print('NO')
