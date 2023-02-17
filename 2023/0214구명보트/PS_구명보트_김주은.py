def solution(people, limit):
    people.sort()
    
    start=0
    end=len(people)-1
    
    answer=0
    
    while start<=end:
        if people[start]+people[end]<=limit:
            start+=1
        answer+=1
        end-=1
    
    return answer
