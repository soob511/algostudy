# https://school.programmers.co.kr/learn/courses/30/lessons/42861

def solution(n, costs):
    costs.sort(key = lambda x: x[2])
    
    ROOTS = [i for i in range(n)]
    answer = 0
    
    for x, y, c in costs:
        #print(ROOTS)
        if x > y:
            x, y = y, x
        if ROOTS[x] != ROOTS[y]:
            answer += c
            
            target = ROOTS[y]
            for i in range(n):
                if ROOTS[i] == target:
                    ROOTS[i] = ROOTS[x]
    
    return answer
