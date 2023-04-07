# https://www.codetree.ai/training-field/frequent-problems/war-finish

N = int(input())
POPS = [list(map(int, input().split())) for _ in range(N)]

answer = 40000

def line_check(add, sub):
    x = (add+sub)//2
    y = (add-sub)//2
    if x<0 or x>=N or y<0 or y>=N:
        return None
    
    return x, y

def calc_sum(top, left, right, bottom, i, j, a, b):
    tribe = [0, 0, 0, 0, 0]
    for x in range(N):
        for y in range(N):
            if   x+y < i and x < left[0] and y <= top[1]:
                tribe[1]+=POPS[x][y]
            
            elif x-y < a and x <= right[0] and y > top[1]:
                tribe[2]+=POPS[x][y]
        
            elif x-y > b and x >= left[0] and y < bottom[1]:
                tribe[3]+=POPS[x][y]
            
            elif x+y > j and x > right[0] and y >= bottom[1]:
                tribe[4]+=POPS[x][y]
            
            else:
                tribe[0]+=POPS[x][y]
    return tribe


# x + y
for i in range(1, 2*N):
    for j in range(i+2, 2*N, 2):
        
        # x - y
        start = -N+2
        if (i^start) % 2 == 1:
            start += 1
        for a in range(start, N-1, 2):
            for b in range(a+2, N-1, 2):
                
                # i/\a
                # b\/j

                top = line_check(i, a)
                left = line_check(i, b)
                right = line_check(j, a)
                bottom = line_check(j, b)

                if top and left and right and bottom:
                    tribe = calc_sum(top, left, right, bottom, i, j, a, b)

                    newanswer = max(tribe) - min(tribe)

                    if newanswer<answer:
                        answer = newanswer

print(answer)
