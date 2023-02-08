from collections import deque

def solution(target):
    
    nums = [[0,0] for i in range(target+1)]

    #bfs탐색
    queue = deque()
    queue.append([0,0,0])

    while queue:
        v = queue.popleft()
        
        if v[0]+50<=target: 
            if nums[v[0]+50][0]==0:
                nums[v[0]+50][0]=v[1]+1
                nums[v[0]+50][1]=v[2]+1
                queue.append([v[0]+50,v[1]+1,v[2]+1])
            elif nums[v[0]+50][0]==v[1]+1 and nums[v[0]+50][1]<v[2]+1:
                nums[v[0]+50][1] = v[2]+1
        
        for cnt in range(1,4):
            for i in range(1,21):
                nextv = v[0]+i*cnt
                if nextv<=target:
                    if nums[nextv][0]==0:
                        nums[nextv][0] = v[1]+1
                        nums[nextv][1] = v[2]+(1 if cnt==1 else 0)
                        queue.append([nextv,v[1]+1,v[2]+(1 if cnt==1 else 0)])
                    elif nums[nextv][0]==v[1]+1 and nums[nextv][1]<v[2]+(1 if cnt==1 else 0):
                        nums[nextv][1] = v[2]+(1 if cnt==1 else 0)
                      
    return [nums[target][0],nums[target][1]]
