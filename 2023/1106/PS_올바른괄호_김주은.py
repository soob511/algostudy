def solution(s):
    
    stack = []
    
    for v in s:
        
        if v =='(':
            stack.append(v)
        else:
            if stack:
                stack.pop()
            else:
                return False
            
    if stack:
        return False
    
    return True
