def solution(numbers, target):
    answer = 0
    
    max_bit = 1 << len(numbers)
    
    for bit in range(max_bit):
        
        result = 0
        
        for idx, num in enumerate(numbers):
            if ((1<<idx) & bit) > 0:
                result += num
            else:
                result -= num
        
        if result == target:
            answer+=1
    
    return answer
