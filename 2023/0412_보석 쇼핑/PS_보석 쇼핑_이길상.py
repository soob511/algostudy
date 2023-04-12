# https://school.programmers.co.kr/learn/courses/30/lessons/67258

def solution(gems):
    answer = []
    
    start = 0
    end = 0
    gem_count = 0
    
    gem_map = {}
    
    for gem in gems:
        # 확장
        end += 1
        if gem not in gem_map:
            gem_map[gem] = 0
        gem_map[gem] += 1
        
        # 축소
        while gems[start] in gem_map and gem_map[gems[start]] > 1:
            gem_map[gems[start]] -= 1
            start += 1
        
        # 갱신
        if len(gem_map) > gem_count:
            gem_count = len(gem_map)
            answer = [start+1, end]
        elif len(gem_map) == gem_count and answer[1]-answer[0] > end-start-1:
            answer = [start+1, end]
            
    
    return answer
