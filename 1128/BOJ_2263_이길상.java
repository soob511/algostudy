import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline
write = sys.stdout.write

N = int(input())

IN = list(map(int, input().split()))
POST = list(map(int, input().split()))
PRE = []

def reorder(in_low, in_high, post_low, post_high):
    if in_low > in_high:
        return

    root = POST[post_high]
    PRE.append(root)

    if in_low == in_high:
        return

    in_root = in_low
    while IN[in_root] != root:
        in_root += 1
    
    left_size = in_root - in_low
    right_size = in_high - in_root

    reorder(in_low, in_root -1, post_low, post_low + left_size - 1)
    reorder(in_root + 1, in_high, post_high-right_size, post_high - 1)

reorder(0, N-1, 0, N-1)

for node in PRE:
    write(str(node) + " ")
