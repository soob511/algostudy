# https://school.programmers.co.kr/learn/courses/30/lessons/42587

def solution(priorities, location):
    ordered = sorted(priorities)
    
    index = 0
    count = 0
    while priorities[location] > 0:
        if priorities[index] == ordered[-1]:
            priorities[index] = 0
            ordered.pop()
            count += 1
        index += 1
        index %= len(priorities)

    return count
