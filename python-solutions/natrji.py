import sys

if __name__ == '__main__':
    start = sys.stdin.readline().strip().split(":")
    end = sys.stdin.readline().strip().split(":")
    start = list(map(int, start))
    end = list(map(int, end))
    start_sec = start[0] * 60 * 60 + start[1] * 60 + start[2]
    end_sec = end[0] * 60 * 60 + end[1] * 60 + end[2]
    if end_sec <= start_sec:
        end_sec += 60 * 60 * 24
    diff = end_sec - start_sec
    hours = diff // (60 * 60)
    minutes = (diff - hours * 60 * 60) // 60
    seconds = diff % 60
    result = [hours, minutes, seconds]
    result = list(map(lambda x: str(x).zfill(2), result))
    print(":".join(result))
