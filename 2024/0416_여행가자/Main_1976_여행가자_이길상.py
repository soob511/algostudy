N = int(input())
M = int(input())

# 초기 루트 노드
roots = [n for n in range(N)]

# N개의 노드 순회
for i in range(N):
    connections = input().split()
    # 쌍방향 연결이므로 i+1부터 순회
    for j in range(i+1, N):
        # 연결되어 있을 경우
        if connections[j] == '1':
            root_of_i = roots[i]
            while root_of_i != roots[root_of_i]:
                root_of_i = roots[root_of_i]
                
            root_of_j = roots[j]
            while root_of_j != roots[root_of_j]:
                root_of_j = roots[root_of_j]
            
            # 양쪽의 루트 노드가 다르면 UNION
            if root_of_i != root_of_j:
                roots[root_of_j] = root_of_i

# 여행 경로 순회하며 루트 노드 저장
roots_of_path = []
for i in map(int, input().split()):
    root_of_i = roots[i-1]
    while root_of_i != roots[root_of_i]:
        root_of_i = roots[root_of_i]
    
    roots_of_path.append(root_of_i)

# 다른게 있으면 NO 프린트하고 종료
for root in roots_of_path:
    if root != roots_of_path[0]:
        print('NO')
        break
else:
    print('YES')
