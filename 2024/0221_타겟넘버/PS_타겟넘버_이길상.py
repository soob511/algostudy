def solution(numbers, target):
    N = len(numbers)
    answer = 0
    
    for i in range(1<<N):
        result = 0
        for num in numbers:
            if i%2 == 0:
                result += num
            else:
                result -= num
            i //= 2
        if result == target:
            answer += 1
            
    return answer
