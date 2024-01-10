# https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=python3

from queue import Queue

def solution(bridge_length, weight, truck_weights):
    bridge = []
    day = 0
    
    while bridge or truck_weights:
        day += 1
        
        # 다리 위에 차가 있고, 나올수 있는 시간이 흐름
        if bridge and bridge[0][1] + bridge_length <= day:
            weight += bridge.pop(0)[0]
        
        # 대기 중인 차가 있고, 다리에 차가 들어갈 공간이 있고, 견딜 무게가 남아있음
        if truck_weights and len(bridge) < bridge_length and weight >= truck_weights[0]:
            weight -= truck_weights[0]
            bridge.append((truck_weights.pop(0), day))

    return day
