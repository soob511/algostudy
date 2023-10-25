# https://school.programmers.co.kr/learn/courses/30/lessons/42895

def solution(N, number):
    # DP[i]: i개의 N을 사용해서 만들수 있는 수 집합
    DP = [set()]
    n = N
    
    # N을 이어붙인 숫자 추가
    for i in range(1, 9):
        DP.append(set([n]))
        n = n*10 + N
    
    for n in range(1, 9):
        for i in range(1, n):
            for x in DP[i]:
                for y in DP[n-i]:
                    # 사칙연산으로 숫자 추가
                    DP[n].add(x+y)
                    DP[n].add(x-y)
                    DP[n].add(x*y)
                    if y!=0:
                        DP[n].add(x//y)
        if number in DP[n]:
            return n
    
    return -1
