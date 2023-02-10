def solution(answers):
    one = [1,2,3,4,5]
    two = [2,1,2,3,2,4,2,5]
    three = [3,3,1,1,2,2,4,4,5,5]
    
    ans = [0,0,0]
    
    for idx, i in enumerate(answers):
        
        if one[idx%5]==i:
            ans[0]+=1
        if two[idx%8]==i:
            ans[1]+=1
        if three[idx%10]==i:
            ans[2]+=1
    
    res = []
    for idx,i in enumerate(ans):
        if i==max(ans):
            res.append(idx+1)
            
    return res
