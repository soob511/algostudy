# https://school.programmers.co.kr/learn/courses/30/lessons/76502?language=python3

def is_valid(s):
    queue = []
    
    for ch in s:
        if ch == ']':
            if queue and queue[-1] == '[':
                queue.pop()
                continue
            return False
        if ch == '}':
            if queue and queue[-1] == '{':
                queue.pop()
                continue
            return False
        if ch == ')':
            if queue and queue[-1] == '(':
                queue.pop()
                continue
            return False
        queue.append(ch)
    
    if queue:
        return False
    
    return True

def solution(s):    
    answer = 0
    for i in range(len(s)):
        if is_valid(s[i:] + s[:i]):
            answer += 1

    return answer
