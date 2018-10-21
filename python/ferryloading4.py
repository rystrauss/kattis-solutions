import sys
from collections import deque


def main():
    c = int(sys.stdin.readline())
    for i in range(c):
        l, m = [int(j) for j in sys.stdin.readline().split()]
        l *= 100
        left = deque()
        right = deque()
        for car in range(m):
            size, side = sys.stdin.readline().split()
            if side == "left":
                left.append(int(size))
            else:
                right.append(int(size))
        crosses = 0
        while len(left) != 0 or len(right) != 0:
            total = 0
            if crosses % 2 == 0:
                while len(left) > 0 and total + left[0] <= l:
                    total += left.popleft()
            else:
                while len(right) > 0 and total + right[0] <= l:
                    total += right.popleft()
            crosses += 1
        print(crosses)


if __name__ == '__main__':
    main()
