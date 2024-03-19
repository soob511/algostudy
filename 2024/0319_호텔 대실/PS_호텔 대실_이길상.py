https://school.programmers.co.kr/learn/courses/30/lessons/155651

# 시간 문자열을 분단위 변환후 정수로 반환
def time_to_min(time):
    hour, minute = time.split(':')
    return 60*int(hour) + int(minute)

def solution(book_time):
    # int 배열로 변환
    book_time = [[time_to_min(start),time_to_min(end)]  for start, end in book_time]
    
    # 방이 필요할때마다 늘어나는 배열
    ROOM = []
    
    # 오름차순으로 정렬 후 순회
    for start, end in sorted(book_time):
        # 손님이 존재하는 방 순회
        for index, booked in enumerate(ROOM):
            # 준비 완료 시간과 입실 시간 비교
            if booked <= start:
                # 준비완료 시간을 퇴실시간 + 10으로 갱신
                ROOM[index] = end + 10
                break
        # 입장 가능한 방이 없으면 새 방에 입실
        else:
             ROOM.append(end + 10)
        ROOM.sort
    
    return len(ROOM)
