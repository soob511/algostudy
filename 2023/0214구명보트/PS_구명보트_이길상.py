# https://school.programmers.co.kr/learn/courses/30/lessons/42885

def solution(people, limit):
    # 오름차순 정렬
    people.sort()
    
    # 투 포인터
    low = 0
    high = len(people)-1
    
    answer = 0
    while low < high:
        # 2명 탈수있는 경우
        if people[low] + people[high] <= limit:
            low+=1
            high-=1
        # 1명 탈수있는 경우
        else:
            high-=1
            
        answer += 1
    
    # 1명 남은 경우
    if low == high:
        answer += 1
    
    return answer
