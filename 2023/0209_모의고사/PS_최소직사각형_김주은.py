def solution(sizes):
    minX = 0
    minY = 0
    for i in sizes:
        if minX < min(i):
            minX = min(i)
        if minY < max(i):
            minY = max(i)
            
    return minX*minY
