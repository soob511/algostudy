TEXT = input()

BRACKETS = {'(':')', '[':']'}
VALUE = {')':2, ']':3}

stack = []
for char in TEXT:
    # 여는 괄호
    if char in BRACKETS:
        stack.append(char)
    # 닫는 괄호
    else:
        value = VALUE[char]
        # 숫자가 있는지 확인
        if stack and type(stack[-1]) == int:
            value *= stack.pop()
        
        # 아무것도 없을 경우
        if not stack:
            stack = [0]
            break
        # 맞는 괄호
        if BRACKETS[stack[-1]] == char:
            stack.pop()

            if stack and type(stack[-1]) == int:
                stack[-1]+= value
            else:
                stack.append(value)
        # 틀린 괄호
        else:
            stack = [0]
            break

if len(stack) != 1 or type(stack[0])!=int:
    print(0)
else:
    print(stack[0])
