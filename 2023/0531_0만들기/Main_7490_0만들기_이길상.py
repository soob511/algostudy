T = int(input())

def calc(expr):
    expr.append('+')
    answer = 0
    number = 0
    op = '+'
    for e in expr:
        if type(e) == int:
            number = number*10 + e
        else:
            if e == ' ':
                continue

            if op == '+':
                answer += number
            elif op == '-':
                answer -= number
            number = 0
            op = e
    expr.pop()

    return answer

for _ in range(T):
    N = int(input())

    result = 1
    stack = [1]
    n = 2
    while stack:
        if n>N:
            if calc(stack) == 0:
                for e in stack:
                    print(e, end='')
                print()
            stack.pop()
            n-=1
        # 공백
        elif stack[-1] == n-1:
            stack.append(' ')
            stack.append(n)
            n+=1
        # 더하기
        elif stack[-1] == ' ':
            stack.pop()
            stack.append('+')
            stack.append(n)
            n+=1
        # 빼기  
        elif stack[-1] == '+':
            stack.pop()
            stack.append('-')
            stack.append(n)
            n+=1
        # 이전으로
        elif stack[-1] == '-':
            stack.pop()
            stack.pop()
            n-=1
    print()
