# https://school.programmers.co.kr/learn/courses/30/lessons/169198

def solution(m, n, sx, sy, balls):
    answer = []
    
    altstart = [-sx, sy, 1], [sx, -sy, 0], [2*m-sx, sy, 1], [sx, 2*n-sy, 0]
    
    for x, y in balls:
        dist = m**2 + n**2
        
        for ax, ay, d in altstart:
            if d == 0:
                if x == sx and min(sy, ay)<y and max(sy, ay)>y:
                    continue
            if d == 1:
                if y == sy and min(sx, ax)<x and max(sx, ax)>x:
                    continue    
            
            dist = min(dist, (ax-x)**2 + (ay-y)**2)
        
        answer.append(dist)
    
    
    return answer
