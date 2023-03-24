# https://school.programmers.co.kr/learn/courses/30/lessons/12979

def solution(n, stations, w):
    answer = 0

    stations.append(n+w+1)
    start = 1
    for s in stations:
        end = s-w
        
        for i in range(start, end, w*2+1):
            answer+=1
        
        start = s+w+1

    return answer
