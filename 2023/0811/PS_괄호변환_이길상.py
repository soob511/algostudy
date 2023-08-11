# https://school.programmers.co.kr/learn/courses/30/lessons/60058

def convert(w):
    if w == '':
        return w
    
    balance = 1 if w[0]=='(' else -1
    is_correct = True if w[0]=='(' else False
    for i in range(1, len(w)):
        a = 1 if w[i]=='(' else -1
        balance += a

        if balance == 0:
            u = w[:i+1]
            v = convert(w[i+1:])
            if is_correct:
                return u+v
            else:
                return '(' + v + ')' + ''.join([')' if ch=='(' else '(' for ch in u[1:-1]])

def solution(p):
    return convert(p)
