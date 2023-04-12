def solution(gems):
    
    answer = []
    
    gems_ = set(gems)
    l = len(gems_)

    start = 0
    end = 0
    shortest = len(gems)+1
    
    d = dict()
    
    while end < len(gems):
        
        if gems[end] not in d:
            d[gems[end]]=0
        d[gems[end]]+=1
        end+=1
        
        if len(d)==l:
            while start<end:
                if d[gems[start]]>1:
                    d[gems[start]]-=1
                    start+=1
                elif shortest > end-start:
                    shortest = end-start
                    answer = [start+1,end]
                    break
                else:
                    break
            
    return answer
