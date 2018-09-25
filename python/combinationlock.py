import sys


def distance(a, b):
    return (a - b) % 40


if __name__ == '__main__':
    while True:
        data = [int(i) for i in sys.stdin.readline().split()]
        if len(set(data)) == 1 and 0 in set(data):
            break
        ticks = 80 + distance(data[0], data[1])
        ticks += 40 + distance(data[2], data[1])
        ticks += distance(data[2], data[3])
        print(9 * ticks)
