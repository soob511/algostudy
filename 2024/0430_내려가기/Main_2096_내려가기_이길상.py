N = int(input())

x_max = x_min = y_max = y_min = z_max = z_min = 0

for _ in range(N):
    x, y, z = map(int, input().split())

    x_max, y_max, z_max = x + max(x_max, y_max), y + max(x_max, y_max, z_max), z + max(y_max, z_max)

    x_min, y_min, z_min = x + min(x_min, y_min), y + min(x_min, y_min, z_min), z + min(y_min, z_min)

max_score = max(x_max, y_max, z_max)
min_score = min(x_min, y_min, z_min)

print(max_score, min_score)
