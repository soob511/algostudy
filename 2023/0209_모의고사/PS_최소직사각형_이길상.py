https://school.programmers.co.kr/learn/courses/30/lessons/86491

def solution(sizes):
    big = []
    small = []
    
    for w, h in sizes:
        big.append(max(w, h))
        small.append(min(w, h))
    
    answer = max(big)*max(small)
    return answer
