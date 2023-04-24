def solution(arr):
    
    l = len(arr)
    return quad(arr,0,0,l)

def quad(arr, x,y,l):

    zero=0
    one=0
    for i in range(x,x+l):
        for j in range(y,y+l):
            if arr[i][j]==0:
                zero+=1
            else:
                one+=1
                
    if zero==l*l:
        return [1, 0]
    elif one==l*l:
        return [0, 1]
    else:
        zero=0
        one=0
        for i in range(x,x+l,l//2):
            for j in range(y,y+l,l//2):
                z, o = quad(arr,i,j,l//2)
                zero+=z
                one+=o
        return [zero, one]
