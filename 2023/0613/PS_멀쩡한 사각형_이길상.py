# https://school.programmers.co.kr/learn/courses/30/lessons/62048

import math

def solution(w,h):
    
    if w > h:
        w, h = h, w
    
    D = math.gcd(w, h)
    W = w//D
    H = h//D
    
    answer = W+H-1
    
    answer *= D
    
    answer = w*h - answer
    
    return answer
