# https://school.programmers.co.kr/learn/courses/30/lessons/12905

def solution(board):
    row = len(board)
    col = len(board[0])
    
    for x in range(1, row):
        for y in range(1, col):
            if board[x][y] > 0:
                board[x][y] = min([board[x-1][y], board[x][y-1], board[x-1][y-1]]) + 1
    
    return max([max(line) for line in board]) ** 2
