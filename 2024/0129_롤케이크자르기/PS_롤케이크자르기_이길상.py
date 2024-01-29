# https://school.programmers.co.kr/learn/courses/30/lessons/132265

def solution(topping):
    # 철수와 동생을 A와 B로 나눔
    A = dict()
    B = set()
    
    # 철수에게 모든 토핑을 주고 기록
    for food in topping:
        if food not in A:
            A[food] = 0
        A[food] += 1
    
    # 토핑을 하나씩 동생에게 주며 공평한 경우 세기
    count = 0
    for food in topping:
        A[food] -= 1
        if A[food] == 0:
            A.pop(food)
        
        B.add(food)
        if len(A) == len(B):
            count += 1 

    return count
