# https://school.programmers.co.kr/learn/courses/30/lessons/147354

def solution(data, col, row_begin, row_end):
    
    edited = [[row[col-1], -row[0], row] for row in data]
    edited.sort()
    
    S = [sum([val%(i+1) for val in line[2]]) for i, line in enumerate(edited)]
    
    answer = 0
    for r in range(row_begin-1, row_end):
        answer ^= S[r]
        
    return answer
