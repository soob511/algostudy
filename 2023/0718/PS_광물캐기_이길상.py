# https://school.programmers.co.kr/learn/courses/30/lessons/172927

COST = {
    "diamond":(1,5,25),
    "iron":(1,1,5),
    "stone":(1,1,1),
}
ANSWER = [1000]


def mine(pick_no, minerals, i):
    costs = 0
    for idx in range(i, i+5):
        if idx >= len(minerals):
            return costs, idx
        costs += COST[minerals[idx]][pick_no]
    
    return costs, i+5


def pickpicks(picks, minerals, i, total):
    if i >= len(minerals) or sum(picks)==0:
        ANSWER[0] = min(ANSWER[0], total)
        return
    
    for p in range(3):
        if picks[p]==0:
            continue
            
        picks[p]-=1
        
        costs, m = mine(p, minerals, i)
        pickpicks(picks, minerals, m, total + costs)
        picks[p]+=1


def solution(picks, minerals):
    pickpicks(picks, minerals, 0, 0)
    return ANSWER[0]
