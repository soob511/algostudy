# https://school.programmers.co.kr/learn/courses/30/lessons/49993
def solution(skill, skill_trees):
    answer = len(skill_trees)
    
    # 선행스킬을 기록할 Map
    prerequisite = dict()
    for i in range(1, len(skill)):
        prerequisite[skill[i]] = skill[i-1]
    
    for skills in skill_trees:
        # 습득한 스킬의 집합
        acquisition = set()
        
        for skill in skills:
            # 선행조건이 있으며 그 조건이 만족되지 않은 경우
            if skill in prerequisite and prerequisite[skill] not in acquisition:
                answer -= 1
                break
            # 습득 스킬에 추가
            acquisition.add(skill)
    
    return answer
