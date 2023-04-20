from collections import defaultdict

def solution(tickets):
    
    path = []
    
    graph = defaultdict(list)
    for start, end in tickets:
        graph[start].append(end)
        
    for airport in graph.keys():
        graph[airport].sort(reverse=True)
        
    stack = ["ICN"]
    
    while stack:
        
        top = stack.pop()
        
        if top not in graph or not graph[top]:
            path.append(top)
            
        else:
            stack.append(top)
            stack.append(graph[top].pop())
            
    return path[::-1]
            
        
        
