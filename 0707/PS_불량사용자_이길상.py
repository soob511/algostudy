def bt(user_id, banned_id, i, check, com_set):
    count = 0;
    
    if i == len(banned_id):
        if check in com_set:
            return 0;
        else:
            com_set.append(check)
            return 1;
    
    bid = banned_id[i]
    
    for idx,uid in enumerate(user_id):
        bit = 1<<idx
        if (check & bit) > 0:
            continue
        if len(bid) == len(uid):
            foo = True
            for j in range(len(bid)):
                if bid[j] == '*':
                    continue
                elif bid[j] != uid[j]:
                    foo = False
                    break
            if foo:
                check += bit
                count += bt(user_id, banned_id, i+1, check, com_set)
                check -= bit
    
    return count



def solution(user_id, banned_id):
    answer = bt(user_id, banned_id, 0, 0, [])
          
    
    return answer
