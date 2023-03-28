# https://school.programmers.co.kr/learn/courses/30/lessons/64064

def solution(user_id, banned_id):
    
    def match(common, banned):
        if len(common) != len(banned):
            return False
        
        for i in range(len(common)):
            if banned[i] == '*':
                continue
            if common[i] != banned[i]:
                return False
        
        return True
    
    matchable = [[i for i, common in enumerate(user_id) if match(common, banned)] for banned in banned_id]
    matched = [False for _ in user_id]
    
    answer = set()

    def matcher(i):
        if i == len(matchable):
            val = 0
            for b in matched:
                val <<= 1
                val += (1 if b else 0)
            answer.add(val)
            return
        
        changed = []
        for n in matchable[i]:
            if matched[n]:
                continue
            
            matched[n] = True
            matcher(i+1)
            matched[n] = False
    
    
    matcher(0)
    
    return len(answer)
