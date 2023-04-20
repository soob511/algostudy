# https://school.programmers.co.kr/learn/courses/30/lessons/42579

def solution(genres, plays):
    GENRE = {}
    
    N = len(genres)
    
    for i in range(N):
        genre = genres[i]
        play = plays[i]
        if genre not in GENRE:
            GENRE[genre] = [0, []]
        
        GENRE[genre][0] += play
        GENRE[genre][1].append((i, play))
    
    answer = []
    for item in sorted(GENRE.items(), key = lambda x:-x[1][0]):
        songs = sorted(item[1][1], key = lambda x:-x[1])
        for i in range(min(2, len(songs))):
            answer.append(songs[i][0])
    
    return answer
