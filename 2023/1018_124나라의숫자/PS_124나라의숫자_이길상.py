def convert(number):
    if number == 3:
        return '4'
    else:
        return str(number)

def solution(n):
    answer = []
    
    while n > 0:
        number = n%3
        if number == 0:
            number = 3
        
        answer.insert(0, convert(number))
        
        n -= number
        n //= 3
    
    return ''.join(answer)
