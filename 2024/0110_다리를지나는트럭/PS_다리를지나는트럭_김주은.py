from collections import deque 

def solution(bridge_length, weight, truck_weights):
    
    bridge = deque([0 for _ in range(bridge_length)])
    
    truck_weights = deque(truck_weights)
    curr_weight = 0
    time = 0
    
    while truck_weights or curr_weight>0 :
        
        if truck_weights:
            truck = truck_weights[0]

            curr_weight-=bridge.pop()
        
            if curr_weight+truck <= weight:
                truck = truck_weights.popleft()
                bridge.appendleft(truck)
                curr_weight+=truck
            else:
                bridge.appendleft(0)       
        else:
            curr_weight-=bridge.pop()
            bridge.appendleft(0)
            
        time+=1

    return time
