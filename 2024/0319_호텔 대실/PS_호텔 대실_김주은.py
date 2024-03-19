from heapq import heappush, heappop

def solution(book_time):
    time = []
    for s,e in book_time:
        s_hour = int(s[1:2] if s[0]=='0' else s[:2])
        s_min = int(s[4:] if s[3]=='0' else s[3:])
        e_hour = int(e[1:2] if e[0]=='0' else e[:2])
        e_min = int(e[4:] if e[3]=='0' else e[3:])
        time.append([s_hour*60+s_min,e_hour*60+e_min+10])
    
    time.sort(key = lambda x : (x[0],x[1]))
    
    heap = []
    
    cnt=1
    heappush(heap,time[0][1])
    
    for i in range(1,len(time)):
        min_end = heappop(heap)
        if time[i][0]<min_end:
            heappush(heap,min_end)
            cnt+=1
        heappush(heap,time[i][1])
            
    return cnt
    
