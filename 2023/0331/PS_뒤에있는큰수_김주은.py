# https://school.programmers.co.kr/learn/courses/30/lessons/154539?language=python3

def solution(numbers):
    
    stack = []
    
    answer = [-1]*len(numbers)
    
    for idx,i in enumerate(numbers):
        while stack and stack[-1][1]<i:
            ids, v = stack.pop()
            answer[ids]=i
        else:
            stack.append([idx, i])
            
    return answer
            
