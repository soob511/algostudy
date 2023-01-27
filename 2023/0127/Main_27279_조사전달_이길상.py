N, M = map(int, input().split())
mans = sorted(list(map(int, input().split())))
works = sorted(list(map(int, input().split())))

def no():
    print("NO")
    exit(0)

while works:
    for i in range(works[-1]):
        if not mans:
            no()
        if mans.pop() < len(works):
            no()
    works.pop()

print("YES")
