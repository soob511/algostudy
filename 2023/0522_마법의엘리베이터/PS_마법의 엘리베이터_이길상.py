# https://school.programmers.co.kr/learn/courses/30/lessons/148653#

def count(num, i):
    big = (10**i)
    small = (10**(i-1))
    
    if num < big:
        return min(num//small, 11-num//small)
    
    rem = num%big
    dist = rem//small
    
    lo = num - rem
    hi = lo + (10**i)
    
    return min(count(lo, i+1)+dist, count(hi, i+1)+10-dist)

def solution(storey):
    
    answer = count(storey, 1)
    return answer
