# https://school.programmers.co.kr/learn/courses/30/lessons/72411

from itertools import combinations

def solution(orders, course):
    # 주문 알파벳 정렬하여 다시 저장
    orders = [sorted(list(word)) for word in orders]
    
    answer = []
    for number in course:
        # number 길이의 주문 조합 저장용 hashmap
        combos = dict()
        
        # orders 순회하며 순열 생성하여 combos에 기록
        for word in orders:
            for combination in combinations(word, number):
                result = ''.join(combination)
                if result not in combos:
                    combos[result] = 0
                combos[result] += 1
        
        # 코스요리 후보가 존재할경우
        if combos.values():
            max_order = max((combos.values()))
            
            # 가장 많이 주문된 횟수가 2보다 클 경우
            if max_order >= 2:
                for key, value in combos.items():
                    if value == max_order:
                        answer.append(key)
    
    return sorted(answer)
