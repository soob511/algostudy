# https://school.programmers.co.kr/learn/courses/30/lessons/42577

def solution(phone_book):
    trie = dict()
    
    for num in phone_book:
        node = trie
        
        for ch in num:
            if "*" in node:
                return False
            
            if ch not in node:
                node[ch] = dict()
            
            node = node[ch]
        
        if len(node) > 0:
            return False
        node["*"] = True
    
    return True
