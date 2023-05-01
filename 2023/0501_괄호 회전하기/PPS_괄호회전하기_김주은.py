def solution(s):
    
    l = len(s)
    seq = [i for i in s]
    
    ans = 0
    
    for _ in range(l):
        
        stack = []
        
        for x in seq:
            if stack:
                if (stack[-1]=='(' and x==')') or (stack[-1]=='[' and x==']') or (stack[-1]=='{' and x=='}'):
                    stack.pop()
                else:
                    stack.append(x)
            else:
                stack.append(x)
                
        if not stack:
            ans+=1
            
        
        first = seq.pop(0)
        seq.append(first)
        

    return ans
