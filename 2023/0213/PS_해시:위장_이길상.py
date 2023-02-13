# https://school.programmers.co.kr/learn/courses/30/lessons/42578

def solution(clothes):
    category = dict()
    for value, key in clothes:
        if key not in category:
            category[key] = []
        category[key].append(value)
    
    count = [len(category[key]) for key in category]
    
    answer = 0
    
    def select(i, n):
        if i==n:
            return 1
        next = select(i+1, n)        

        return (count[i]+1) * next
    
    return select(0, len(count))-1
