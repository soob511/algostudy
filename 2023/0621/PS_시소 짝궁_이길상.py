# https://school.programmers.co.kr/learn/courses/30/lessons/152996#

def solution(weights):
    count = dict()
    for w in weights:
        if w in count:
            count[w] += 1
        else:
            count[w] = 1
        
    
    answer = 0
    for w in count:
        answer += count[w]*(count[w]-1)//2
        if w*3/2 in count:
            answer += count[w]*count[w*3/2]
        if w*2 in count:
            answer += count[w]*count[w*2]
        if w*4/3 in count:
            answer += count[w]*count[w*4/3]
    
    
    return answer
