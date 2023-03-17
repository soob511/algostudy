def solution(n, lost, reserve):
    answer = n-len(lost)
    
    lost.sort()
    reserve.sort()
    
    for i in lost[::-1]:
        if i in reserve[::-1]:
            lost.remove(i)
            reserve.remove(i)
            answer+=1
            
    print(lost, reserve)
    
    i=0
    j=0
    while i<len(lost) and j<len(reserve):
        
        if reserve[j]-1>lost[i]:
            i+=1
        elif reserve[j]-1<=lost[i]<=reserve[j]+1:
            i+=1
            j+=1
            answer+=1
        elif reserve[j]+1<lost[i]:
            j+=1
            
    return answer
