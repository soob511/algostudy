from functools import cmp_to_key

def solution(numbers):
    
    numbers = list(map(lambda x: str(x), numbers))
    numbers = sorted(numbers, key=cmp_to_key(lambda a, b: -1 if a+b >= b+a else 1))
    answer = ''.join(numbers)

    return str(int(answer))
