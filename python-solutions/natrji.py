import sys

if __name__ == '__main__':
    start = sys.stdin.readline().strip().split(":")
    end = sys.stdin.readline().strip().split(":")
    start = list(map(int, start))
    end = list(map(int, end))
    result = [0, 0, 0]
    if start[2] <= end[2]:
        result[2] += end[2] - start[2]
    else:
        result[2] += 60 - start[2] + end[2]
        result[1] -= 1
    if start[1] <= end[1]:
        result[1] += end[1] - start[1]
    else:
        result[1] += 60 - start[1] + end[1]
        result[0] -= 1
    if start[0] <= end[0]:
        result[0] += end[0] - start[0]
    else:
        result[0] += 24 - start[0] + end[0]
    result = list(map(lambda x: str(x).zfill(2), result))
    print(":".join(result))
