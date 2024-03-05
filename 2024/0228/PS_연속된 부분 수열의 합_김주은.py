def solution(sequence, k):
    
    candidate = []
    l = len(sequence)
    
    start = 0
    end = 0
    sums = sequence[0]
    
    while start<=end:
        if sums>k:
            sums-=sequence[start]
            start+=1
        else:
            if sums==k:
                candidate.append([start,end])
            if end<l:
                if end+1==l:
                    break
                sums+=sequence[end+1]
                end+=1

    candidate.sort(key=lambda x:(x[1]-x[0],x[0]))
    
    return candidate[0]
    
        
