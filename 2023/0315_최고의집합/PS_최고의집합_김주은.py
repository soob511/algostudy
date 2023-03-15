def solution(n, s):

    if s<n:
        return [-1]
    
    q = int(s//n)
    r = s-q*n
    
    answer = [q for _ in range(n-r)] + [q+1 for _ in range(r)]
    
    return answer
