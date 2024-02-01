
def solution(orders, course):
    
    answer = []
    
    global d
    d = {}

    for order in orders:
        lens = len(order)
        for c in course:
            if c<=lens:
                combination(0, 0, c, [0]*c, lens, sorted(order))
                
    cnt = {k:2 for k in course}
    lists = {k:[] for k in course}
    
    for k, v in d.items():
        if v==cnt[len(k)]:
            lists[len(k)].append(k)
        elif v>cnt[len(k)]:
            cnt[len(k)]=v
            lists[len(k)]=[k]

            
    for k, v in lists.items():
        for val in v:
            answer.append(val)
        
    return sorted(answer)
        
def combination(cnt, idx, r, sel, n, arr):
    if cnt==r:
        tmp = ''.join(sel)
        d[tmp] = d.get(tmp,0) + 1
        return
    
    for i in range(idx, n):
        sel[cnt]=arr[i]
        combination(cnt+1, i+1, r, sel, n, arr)
