# https://school.programmers.co.kr/learn/courses/30/lessons/49993

def solution(skill, skill_trees):
    
    answer = len(skill_trees)
    
    for sktree in skill_trees:
        sidx=0
        for s in sktree:
            if s not in skill:
                continue
            else:
                if skill[sidx]==s:
                    sidx+=1
                    continue
                else:
                    answer-=1
                    break
            
        
    return answer
