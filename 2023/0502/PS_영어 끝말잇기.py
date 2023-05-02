# https://school.programmers.co.kr/learn/courses/30/lessons/12981

def solution(n, words):
    L = len(words)
    player = dict()
    used = set()
    
    for i in range(n):
        player[i] = 0
    
    prev = words[0][:1]
    
    i = 0
    for curr in words:
        if curr not in used and prev[-1] == curr[0]:
            used.add(curr)
            player[i % n] += 1
            prev = curr
        
        else:
            return [i % n + 1, player[i % n] + 1]
        
        i += 1
    
    return [0, 0]
