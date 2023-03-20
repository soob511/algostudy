# https://school.programmers.co.kr/learn/courses/30/lessons/77485

def solution(rows, columns, queries):
    answer = []
    
    map_ = [[i*columns+j+1 for j in range(columns)] for i in range(rows)]
    
    for query in queries:
        
        x1, y1, x2, y2 = query
        x1-=1
        y1-=1
        x2-=1
        y2-=1
        
        temp = map_[x1][y1]
        min_ = map_[x1][y1]
        for i in range(x1,x2):
            if map_[i][y1]<min_:
                min_ = map_[i][y1]
                
            map_[i][y1]=map_[i+1][y1]
        
        for j in range(y1,y2):
            if map_[x2][j]<min_:
                min_ = map_[x2][j]
                
            map_[x2][j]=map_[x2][j+1]
        
        for i in range(x2,x1,-1):
            if map_[i][y2]<min_:
                min_=map_[i][y2]
                
            map_[i][y2]=map_[i-1][y2]
            
        for j in range(y2,y1,-1):
            if map_[x1][j]<min_:
                min_=map_[x1][j]
            
            map_[x1][j]=map_[x1][j-1]
            
        map_[x1][y1+1]=temp
        
        answer.append(min_)
    
    
    
    
    
    
    
    
    
    
    
    
    
    return answer
