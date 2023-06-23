# https://school.programmers.co.kr/learn/courses/30/lessons/12909

def solution(s):
    
    stack = []
    
    for par in s:
        
        if stack:
            if stack[-1]=='(' and par==')':
                stack.pop()
            else:
                stack.append(par)
        else:
            stack.append(par)
            
            
    if stack:
        return False
    
    return True
