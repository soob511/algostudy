# https://school.programmers.co.kr/learn/courses/30/lessons/87377?language=python3

def intersection(l1, l2):
    a, b, c = l1
    d, e, f = l2
    
    if a*e == b*d:
        return False, 0, 0

    s = (b*f-c*e)%(a*e-b*d)
    t = (a*f-c*d)%(b*d-a*e)
    
    if s!=0 or t!=0:
        return False, s, t
    
    x = (b*f-c*e)//(a*e-b*d)
    y = (a*f-c*d)//(b*d-a*e)
    
    return True, x, y


def solution(line):
    points = []
    X = []
    Y = []
    for l1 in line:
        for l2 in line:
            if l1 != l2:
                k, x, y = intersection(l1, l2)
                if k:
                    X.append(x)
                    Y.append(y)
                    points.append((x, y))
                    
    coord = [['.' for x in range(min(X), max(X)+1)] for y in range(min(Y), max(Y)+1)]
    for x, y in points:
        coord[-(y-min(Y)+1)][x-min(X)] = '*'

    return [ ''.join(line) for line in coord]
