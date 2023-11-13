# https://school.programmers.co.kr/learn/courses/30/lessons/135807

from math import gcd

def solution(arrayA, arrayB):
    gcdA = arrayA[0]
    for a in arrayA:
        gcdA = gcd(gcdA, a)
    gcdB = arrayB[0]
    for b in arrayB:
        gcdB = gcd(gcdB, b)
    
    answer = 0
    for a in arrayA:
        if a % gcdB == 0:
            break
    else:
        answer = gcdB
    
    for b in arrayB:
        if b % gcdA == 0:
            break
    else:
        answer = max(answer, gcdA)
    
    return answer
