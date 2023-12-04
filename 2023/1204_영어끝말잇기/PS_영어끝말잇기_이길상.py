# https://school.programmers.co.kr/learn/courses/30/lessons/12981

def solution(n, words):
    prev = words[0][0]
    used = set()
    
    for i, word in enumerate(words):
        if word in used or prev[-1] != word[0]:
            return [i%n + 1, i//n + 1]
        
        prev = word
        used.add(word)
    
    return [0, 0]
