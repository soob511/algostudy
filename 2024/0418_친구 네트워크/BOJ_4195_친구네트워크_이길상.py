T = int(input())

for _ in range(T):
    F = int(input())

    # 부모 노드
    parent = dict()
    # 자식 노드들의 수
    child_count = dict()
    
    for f in range(F):
        a, b = input().split()

        # 딕셔너리에 등록
        if a not in parent:
            parent[a] = a
        if b not in parent:
            parent[b] = b
        if a not in child_count:
            child_count[a] = 1
        if b not in child_count:
            child_count[b] = 1

        # 루트 노드 찾기
        root_a = a
        root_b = b
        while root_a != parent[root_a]:
            root_a = parent[root_a]
        # b경로의 노드들은 부모 노드를 a경로의 루트로 변경
        while root_b != parent[root_b]:
            temp = parent[root_b]
            parent[root_b] = root_a
            root_b = temp

        # 자식 노드 수 갱신        
        if root_a != root_b:
            parent[root_b] = root_a
            child_count[root_a] += child_count[root_b]
        
        # 출력
        print(child_count[root_a])
