answer = 100000000

def solution(storey):
    
    global n
    n = len(str(storey))
    
    dfs(storey,0,0)
    
    return answer
    
def dfs(storey, cnt, time):
    
    global n, answer
    if cnt==n:
        if time+storey<answer:
            answer=time+storey
        return
    
    if storey%10 ==0:
        dfs(storey//10,cnt+1,time)
    else:
        a = storey%10
        b = 10-a
        
        dfs((storey-a)//10,cnt+1,time+a)
        dfs((storey+b)//10,cnt+1,time+b)
    
