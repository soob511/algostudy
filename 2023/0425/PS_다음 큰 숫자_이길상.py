# https://school.programmers.co.kr/learn/courses/30/lessons/12911

def solution(n):
    BIN = []
    while n>0:
        BIN.append(n%2)
        n //= 2
    BIN.append(0)
    
    idx = 0
    count = 0
    while not (BIN[idx] == 1 and BIN[idx+1] == 0):
        if BIN[idx] == 1:
            count += 1
        idx+=1
        
    BIN[idx] = 0
    BIN[idx+1] = 1

    answer = 0
    for i in range(count):
        answer += (1<<i)
    
    for i in range(idx, len(BIN)):
        answer += (BIN[i]<<i)
    
    return answer
