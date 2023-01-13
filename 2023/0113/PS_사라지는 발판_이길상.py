# https://school.programmers.co.kr/learn/courses/30/lessons/92345

def solution(board, aloc, bloc):
    X = len(board)
    Y = len(board[0])
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    
    def movable(loc):
        if loc[0]<0 or loc[0]>=X or loc[1]<0 or loc[1]>=Y:
            return False
        if board[loc[0]][loc[1]] == 0:
            return False
        return True
    
    def update_case(me, opponent):
        if me[0] == "lose":
            if opponent[0] == "lose":
                me[0] = "win"
                me[1] = opponent[1]
            elif opponent [1] > me[1]:
                me[1] = opponent[1]
        else:
            if opponent[0] == "lose" and opponent[1] < me[1]:
                me[1] = opponent[1]
        
    def move (me, opponent):
        if not movable(me):
            return ["lose", 0]
        
        board[me[0]][me[1]] = 0
        
        case = ["lose", -1]
        
        for d in range(4):
            moved = [ me[0]+dx[d], me[1]+dy[d] ]
            if movable(moved):
                update_case(case, move(opponent, moved))
        
        board[me[0]][me[1]] = 1
        case[1]+=1
        return case
        
    res = move(aloc, bloc)
    
    return res[1]
