from collections import deque

# 입력
S, T = map(int, input().split())

if T == S:
    print(0)
else:
    operation = (
    ('*', lambda x: x*x), 
    ('+', lambda x: x+x), 
    ('/', lambda _: 1)
    ) # 연산 목록
    Q = deque() # 이중 연결 리스트
    known = set() # 연산 결과 숫자 집합

    Q.append((S, ()))

    while Q:
        s, record = Q.popleft()

        for operand, function in operation:
            next = function(s)
            
            if next in known:
                continue
                
            if next > T:
                continue
            
            known.add(next)
            Q.append((next, (*record, operand)))

            if next == T:
                print(''.join(Q.pop()[1]))
                exit(0)
    print(-1)
