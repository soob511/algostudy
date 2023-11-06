def solution(skill, skill_trees):
    
    answer = len(skill_trees)
    
    for skills in skill_trees:
        idx=0
        for s in skills:
            if s in skill:
                if s==skill[idx]:
                    idx+=1
                else:
                    answer-=1
                    break
            else:
                continue        
                
    return answer
