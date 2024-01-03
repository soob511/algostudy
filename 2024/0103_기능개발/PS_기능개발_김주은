def solution(progresses, speeds):
    
    answer = []
    days = []
    
    n = len(progresses)
    
    for i in range(n):
        days.append((100-progresses[i]-1)//speeds[i]+1)
        
    cnt = 1
    num = days[0]
    for i in days[1:]:
        if num<i:
            answer.append(cnt)
            num=i
            cnt=1
        else:
            cnt+=1
                
    answer.append(cnt)
    return answer
