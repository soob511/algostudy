# https://school.programmers.co.kr/learn/courses/30/lessons/181188

def solution(targets):
    targets.sort()
    answer = 1
    start = targets[0][0]
    end = targets[0][1]
    
    for s, e in targets:
        if s<end:
            start = s
            if e<end:
                end = e
        else:
            start = s
            end = e
            answer += 1
    
    return answer
