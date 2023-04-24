# https://school.programmers.co.kr/learn/courses/30/lessons/68936

def quadzip(arr, x, y, d):
    # 사이즈가 1일 경우
    if d == 1:
        return [arr[x][y]]
    
    # 구역 4개로 나누어 재귀 적용
    result = []
    for nx in range(x, x+d, d//2):
        for ny in range(y, y+d, d//2):
            result.extend(quadzip(arr, nx, ny, d//2))
    
    # 압축되는지 확인
    if len(result) == 4:
        if sum(result) == 0:
            return [0]
        if sum(result) == 4:
            return [1]
    
    return result

def solution(arr):
    # 압축본 생성
    zipped = quadzip(arr, 0, 0, len(arr))
    
    # 0과 1의 개수 세기
    one = sum(zipped)
    zero = len(zipped) - one
    
    answer = [zero, one]
    return answer
