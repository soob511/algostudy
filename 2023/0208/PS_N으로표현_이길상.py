# https://school.programmers.co.kr/learn/courses/30/lessons/42895

def solution(N, number):
    DP = [set()]
    n = N
    for i in range(1, 9):
        DP.append(set([n]))
        n = n*10 + N
    
    for n in range(1, 9):
        for i in range(1, n):
            for x in DP[i]:
                for y in DP[n-i]:
                    DP[n].add(x+y)
                    DP[n].add(x-y)
                    DP[n].add(x*y)
                    if y!=0:
                        DP[n].add(x//y)
        #print(n,":",DP[n])
        if number in DP[n]:
            return n
    
    return -1
