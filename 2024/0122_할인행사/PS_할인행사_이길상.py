# https://school.programmers.co.kr/learn/courses/30/lessons/131127?language=python3

from collections import deque

def check(hashmap, required):
    for food, number in required:
        if food not in hashmap or hashmap[food] < number:
            return False
    
    return True
    

def solution(want, number, discount):
    
    hashmap = dict()
    queue = deque()
    
    required = [(want[i], number[i]) for i in range(len(number))]
    
    for food in want:
        hashmap[food] = 0
    
    # 첫 10개 기록
    for food in discount[:10]:
        if food not in hashmap:
            hashmap[food] = 0
        queue.append(food)
        hashmap[food] += 1
    
    # 첫 10개가 조건을 만족하는지 체크
    result = 1 if check(hashmap, required) else 0
        
    # 나머지 할인정보 하나씩 확인하면서 큐와 해시맵에 기록
    for food in discount[10:]:
        if food not in hashmap:
            hashmap[food] = 0
        queue.append(food)
        hashmap[food] += 1
        
        poped = queue.popleft()
        hashmap[poped] -= 1
        
        # 조건을 만족하는지 체크
        if check(hashmap, required):
            result += 1
            
    return result
