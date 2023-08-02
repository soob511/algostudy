# https://school.programmers.co.kr/learn/courses/30/lessons/67257

def solution(expression):
    num_stack = []
    op_stack = []
    
    def calculation():
        op = op_stack.pop()
        y = num_stack.pop()
        x = num_stack.pop()
        if op == '+':
            num_stack.append(x+y)
        elif op == '-':
            num_stack.append(x-y)
        else:
            num_stack.append(x*y)

    cases = [
        {'+':2, '-':1, '*':3},
        {'+':1, '-':2, '*':3},
        {'+':1, '-':3, '*':2},
        {'+':3, '-':1, '*':2},
        {'+':2, '-':3, '*':1},
        {'+':3, '-':2, '*':1},
    ]
    results = []
    
    for priority in cases:
        num = 0
        for ch in expression:
            if ch.isdecimal():
                num = num*10 + int(ch)
            else:
                num_stack.append(num)
                num = 0
                while op_stack and priority[op_stack[-1]] >= priority[ch]:
                    calculation()
                op_stack.append(ch)
                
        num_stack.append(num)
        while op_stack:
            calculation()
        results.append(abs(num_stack.pop()))
    
    return max(results)
