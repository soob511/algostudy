# https://school.programmers.co.kr/learn/courses/30/lessons/12936

def solution(n, k):
    cases = 1
    for i in range(1, n+1):
        cases *= i
    
    nums = [i+1 for i in range(n)]
    result = []
    count = 0
    
    for i in range(n, 0, -1):
        cases /= i
        for num in nums:
            if count + cases >= k:
                result.append(num)
                nums.remove(num)
                break
            count += cases       
                
    return result
