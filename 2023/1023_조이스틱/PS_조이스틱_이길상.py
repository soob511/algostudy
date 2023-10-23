# https://school.programmers.co.kr/learn/courses/30/lessons/42860

def alphabet_diff(let):
    diff = ord(let)-ord('A')
    return min(diff, 26-diff)

def solution(name):
    answer = len(name) - 1
    start = 0
    end = 0
    
    # 연속한 A 구간 찾기
    for i in range(1, len(name)):
        if name[i] == 'A' and name[i-1] != 'A':
            start = i-1
        if name[i] == 'A' and (i+1 == len(name) or name[i+1] != 'A') :
            end = i+1
            
            # 해당 구간 제외했을때 좌우 최단거리 계산
            low = min(start, len(name)-end)
            high = max(start, len(name)-end)
            
            answer = min(answer, low*2 + high)
    
    # 상하 조작은 최적화 불필요
    for let in name:
        answer += alphabet_diff(let)

    return answer
