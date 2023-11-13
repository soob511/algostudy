# https://school.programmers.co.kr/learn/courses/30/lessons/68645

def solution(n):
    total = sum(range(1, n + 1))
    pyramid = [0 for _ in range(total)]
    
    i = 1
    idx = 0
    row = 1
    while n > 0:
        # /
        for _ in range(n):
            pyramid[idx] = i
            idx += row
            row += 1
            i += 1
        idx -= (row - 2)
        n -= 1
        
        # _
        for _ in range(n):
            pyramid[idx] = i
            idx += 1
            i += 1
        idx -= 1
        n -= 1
        row -= 1
        
        # \
        for _ in range(n):
            idx -= row
            pyramid[idx] = i
            row -= 1
            i += 1
        idx += row
        row += 1
        n -= 1
        
    return pyramid
