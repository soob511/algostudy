def solution(record):
    answer = []
    
    uid = dict()
    text = {"Enter":"님이 들어왔습니다.", "Leave":"님이 나갔습니다."}
    temp = []
    
    for rec in record:
        r = rec.split(" ")
        
        if r[0]=="Enter":
            uid[r[1]]=r[2]
            temp.append([r[1],r[0]])
        elif r[0]=="Leave":
            temp.append([r[1],r[0]])
        elif r[0]=="Change":
            uid[r[1]]=r[2]
            
    for ids, dirs in temp:
        answer.append(uid[ids]+text[dirs])
    
    return answer
